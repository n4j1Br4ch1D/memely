import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class TagService {

  constructor(private http: HttpClient) { }
  ResPath = environment.apiUrl+'tags';

  getAll(): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}`);
  }
}
