import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemeService {

  constructor(private http: HttpClient) { }

  apiUrl = 'http://localhost:8081/api/v1/users';

  getAll(): Observable<Object> {
    return this.http.get<Object>(`${this.apiUrl}`);
  }
}
