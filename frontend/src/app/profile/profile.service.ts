import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Profile } from '../_models/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  constructor(private http: HttpClient) { }
  ResPath = environment.apiUrl+'users';

  getAll(): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}`);
  }
  getOne(id: any): Observable<Profile> {
    return this.http.get<Profile>(`${this.ResPath}/${id}`);
  }
  getOneByUsername(username: string | null): Observable<Profile> {
    return this.http.get<Profile>(`${this.ResPath}/username/${username}`);
  }
  getFollowers(id: any): Observable<Profile> {
    return this.http.get<Profile>(`${this.ResPath}/${id}/followers`);
  }
  getFollowing(id: any): Observable<Profile> {
    return this.http.get<Profile>(`${this.ResPath}/${id}/following`);
  }
  
}
