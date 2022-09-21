import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  constructor() { }
  signedInUser:any = {
    id: 1,
    name: 'Najib Rachid',
    username: 'najib-rachid',
    email: 'najib@anmoon.ma',
    role: 'admin'
  };

  setSignedInUser(temp: any): void {
    return this.signedInUser = temp;
  }

  getSignedInUser(): any {
    return this.signedInUser;
  }

}
