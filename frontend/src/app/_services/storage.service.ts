import { Injectable } from '@angular/core';

const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class StorageService {
  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user).user;
    }

    return {};
  }

  public isSignedIn(): boolean {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return true;
    }
    return false;
  }

  public isAdmin(): boolean {
    const user:any = window.sessionStorage.getItem(USER_KEY);
    const userParsed =  JSON.parse(user);
    if (userParsed?.user?.role=="ROLE_ADMIN") {
      return true;
    }
    return false;
  }
}
