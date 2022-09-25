import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  constructor(private http: HttpClient) { }
  ResPath = environment.apiUrl+'messages';
  getUserMessages(userId: Number, friendId: Number): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}/user/${userId}/friend/${friendId}`);
  }
  getUserMessagesFriends(userId: Number): Observable<Object> {
    return this.http.get<Object>(`${this.ResPath}/${userId}/friends`);
  }
}
