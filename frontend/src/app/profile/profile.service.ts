import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../_models/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  apiUrl = 'https://jsonplaceholder.typicode.com/users';

  get(id: any): Observable<Profile> {
    return this.http.get<Profile>(`${this.apiUrl}/${id}`);
  }
}
