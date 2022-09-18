/* eslint-disable @typescript-eslint/adjacent-overload-signatures */
import {Injectable, PipeTransform} from '@angular/core';

import {BehaviorSubject, Observable, of, Subject} from 'rxjs';

import {Profile} from './profile';
import {DecimalPipe} from '@angular/common';
import {debounceTime, delay, switchMap, tap} from 'rxjs/operators';
import {SortColumn, SortDirection} from './sortable.directive';
import { HttpClient } from '@angular/common/http';

interface SearchResult {
  profiles: Profile[];
  total: number;
}

interface State {
  page: number;
  pageSize: number;
  searchTerm: string;
  filterRole: string;
  sortColumn: SortColumn;
  sortDirection: SortDirection;
}

const compare = (v1: string | number, v2: string | number) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

function sort(profiles: Profile[], column: SortColumn, direction: string): Profile[] {
  if (direction === '' || column === '') {
    return profiles;
  } else {
    return [...profiles].sort((a, b) => {
      const res = compare(a[column], b[column]);
      return direction === 'asc' ? res : -res;
    });
  }
}

function matches(Profile: Profile, term: string, role: string, pipe: PipeTransform) {
    if(role==""){
      return Profile.name.toLowerCase().includes(term.toLowerCase())
      || Profile.username.toLowerCase().includes(term.toLowerCase())
      || Profile.email.toLowerCase().includes(term.toLowerCase())
      || Profile.username===role;
      // || pipe.transform(Profile.id).includes(term);
      // || pipe.transform(Profile.population).includes(term);  
    }else{
     return  Profile.username===role;
    }

}

@Injectable({providedIn: 'root'})
export class ProfileService {
  private _loading$ = new BehaviorSubject<boolean>(true);
  private _search$ = new Subject<void>();
  private _profiles$ = new BehaviorSubject<Profile[]>([]);
  private _total$ = new BehaviorSubject<number>(0);

  private _state: State = {
    page: 1,
    pageSize: 5,
    searchTerm: '',
    filterRole: '',
    sortColumn: '',
    sortDirection: ''
  };
  profiles: Profile[] = [];

  constructor(private http: HttpClient, private pipe: DecimalPipe) {
    this.getProfiles();
    this._search$.pipe(
      tap(() => this._loading$.next(true)),
      debounceTime(200),
      switchMap(() => this._search()),
      delay(200),
      tap(() => this._loading$.next(false))
    ).subscribe(result => {
      this._profiles$.next(result.profiles);
      this._total$.next(result.total);
    });

    this._search$.next();
    
  }


  getProfiles() : void {
    this.http.get<Profile[]>('./assets/data/profiles.json')
      .subscribe((data: Profile[]) => {        
        this.profiles = data;
      });      
  }

  


  get profiles$() { return this._profiles$.asObservable(); }
  get total$() { return this._total$.asObservable(); }
  get loading$() { return this._loading$.asObservable(); }
  get page() { return this._state.page; }
  get pageSize() { return this._state.pageSize; }
  get searchTerm() { return this._state.searchTerm; }
  get filterRole() { return this._state.filterRole; }


  

  set page(page: number) { this._set({page}); }
  set pageSize(pageSize: number) { this._set({pageSize}); }
  set searchTerm(searchTerm: string) { this._set({searchTerm}); }
  set filterRole(filterRole: string) { this._set({filterRole}); }
  set sortColumn(sortColumn: SortColumn) { this._set({sortColumn}); }
  set sortDirection(sortDirection: SortDirection) { this._set({sortDirection}); }

  private _set(patch: Partial<State>) {
    Object.assign(this._state, patch);
    this._search$.next();
  }

  private _search(): Observable<SearchResult> {    

    const {sortColumn, sortDirection, pageSize, page, searchTerm, filterRole} = this._state;

    // 1. sort
    let profiles = sort(this.profiles, sortColumn, sortDirection);

    // 2. filter
    console.log("term", searchTerm);
    console.log("role", filterRole);

    profiles = profiles.filter(Profile => matches(Profile, searchTerm, filterRole, this.pipe));
    const total = profiles.length;

    // 3. paginate
    profiles = profiles.slice((page - 1) * pageSize, (page - 1) * pageSize + pageSize);
    return of({profiles, total});
  }
}