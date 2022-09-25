import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MentionService {
  constructor(private http: HttpClient) { }
  ResPath = environment.apiUrl+'mentions';

  getuserMentions(userId: Number): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}/user/${userId}`);
  }
}
