import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Role } from '../_enums/role';
import { Profile } from '../_models/profile';
import { AuthService } from '../_services/auth.service';
import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private storageService: StorageService,
    private router: Router
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.storageService.isSignedIn()) {
       if (this.storageService.getUser()['role']=="ROLE_ADMIN") {
        return true;
       } else {
        this.router.navigate(['/profile']);
        return false;
       }
    } else {
      this.router.navigateByUrl(`/dashboard/404`, {skipLocationChange: true})
      return false;
    }
  }
}
