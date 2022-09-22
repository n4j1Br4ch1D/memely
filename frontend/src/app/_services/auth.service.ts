import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const AUTH_API = 'http://localhost:8081/api/v1/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AuthService {
 
  constructor(private http: HttpClient) {}
  signedInUser:any = {
    id: 1,
    name: 'Najib Rachid',
    username: 'najib-rachid',
    email: 'najib@anmoon.ma',
    role: 'admin'
  };

  signIn(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + `signin`,
      {
        username,
        password,
      },
      httpOptions
    );
  }

  // register(username: string, email: string, password: string): Observable<any> {
  //   return this.http.post(
  //     AUTH_API + 'signup',
  //     {
  //       username,
  //       email,
  //       password,
  //     },
  //     httpOptions
  //   );
  // }

  signOut(): Observable<any> {
    return this.http.post(AUTH_API + 'signout', { }, httpOptions);
  }

  setSignedInUser(temp: any): void {
    return this.signedInUser = temp;
  }

  getSignedInUser(): any {
    return this.signedInUser;
  }

}
