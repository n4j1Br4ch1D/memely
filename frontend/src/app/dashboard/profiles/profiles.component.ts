import {DecimalPipe} from '@angular/common';
import {Component, OnInit, QueryList, ViewChildren} from '@angular/core';
import {Observable} from 'rxjs';

import {Profile} from './profile';
import {ProfileService} from './profiles.service';
import {NgbdSortableHeader, SortEvent} from './sortable.directive';





  @Component({
    selector: 'app-profiles',
    templateUrl: './profiles.component.html',
    styleUrls: ['./profiles.component.scss'],
    providers: [ProfileService, DecimalPipe]
    
  })

  export class ProfilesComponent implements OnInit {
  profiles$: Observable<Profile[]>;
  total$: Observable<number>;

  @ViewChildren(NgbdSortableHeader)
    headers!: QueryList<NgbdSortableHeader>;

  constructor(public service: ProfileService) {
    this.profiles$ = service.profiles$;
    this.total$ = service.total$;
  }

  ngOnInit(): void {
  }

  onSort({column, direction}: SortEvent) {
    // resetting other headers
    this.headers.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.service.sortColumn = column;
    this.service.sortDirection = direction;
  }
}