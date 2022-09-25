import { Injectable } from '@angular/core';

const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class StorageService {
//  storageUnit = window.sessionStorage;
 storageUnit = window.localStorage;
 // session Coockie;


  clean(): void {
    this.storageUnit.clear();
  }

  public saveUser(user: any): void {
    this.storageUnit.removeItem(USER_KEY);
    this.storageUnit.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = this.storageUnit.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user).user;
    }

    return {};
  }

  public isSignedIn(): boolean {
    const user = this.storageUnit.getItem(USER_KEY);
    if (user) {
      return true;
    }
    return false;
  }

  public isAdmin(): boolean {
    const user:any = this.storageUnit.getItem(USER_KEY);
    const userParsed =  JSON.parse(user);
    if (userParsed?.user?.role=="ROLE_ADMIN") {
      return true;
    }
    return false;
  }
}
