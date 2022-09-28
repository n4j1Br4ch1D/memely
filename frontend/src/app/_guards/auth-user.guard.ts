import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ProfileService } from '../profile/profile.service';
import { Role } from '../_enums/role';
import { Profile } from '../_models/profile';
import { AuthService } from '../_services/auth.service';
import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthUserGuard implements CanActivate {
  constructor(
    private storageService: StorageService,
    private profileService: ProfileService,
    private router: Router,
    private route: ActivatedRoute
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.storageService.isSignedIn()) {
       if (this.storageService.getUser()['role']=="ROLE_ADMIN" || this.storageService.getUser()['role']=="ROLE_USER") {
       console.log("allowed", this.storageService.getUser()['role']);
           //if mine 
           console.log("current_id", this.profileService.getCurrentProfile()['id']);
           console.log("is it allowed", route.data['allowed']);
           
           if (this.storageService.getUser()['id']==this.profileService.getCurrentProfile()['id']
             ||  route.data['allowed']
           ) {
            console.log("allowed Mine or Allowed");
            return true;
           } 
           console.log("disallowed Else  or Disallowed");

      this.router.navigateByUrl(`/memes/404`, {skipLocationChange: true})
         return  false;
       } else {
        console.log("disallowed", this.storageService.getUser()['role']);
         // Sign-in or Sign-up 1st. 
        return false;
       }
    } else {
      console.log("disallowed Guest", this.storageService.getUser()['role']);
      // Sign-in or Sign-up 1st. 
      return false;
    }
  }
}
