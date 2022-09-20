import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Role } from '../_enums/role';
import { Profile } from '../_models/profile';
import { AuthService } from '../_services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
  ) {}



  canActivate(
    
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const logedInUser:Profile | any = {
      id: 1,
      name: 'Najib Rachid',
      username: 'najib-rachid',
      email: 'najib@anmoon.ma',
      role: Role.ADMIN
    }
    let signedIn: boolean = true;
    let role :Role = route.data['role']; 
    if (signedIn) {
       if (logedInUser.role==Role.ADMIN) {
        // this.router.navigate(['/dashboard']);
        return true;
       } else {
        this.router.navigate(['/profile']);
        return false;
       }
    } else {
      this.router.navigate(['auth/sign-in']);
      return false;
    }
  }


 
}
