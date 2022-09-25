import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class MemeService {

  constructor(private http: HttpClient) { }
  ResPath = environment.apiUrl+'memes';

  getAll(): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}`);
  }

  getAllByTag(tag: String): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}/tag/${tag}`);
  }

  search(keyword: String): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}/search/${keyword}`);
  }
}
