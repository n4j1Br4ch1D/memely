import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { EMPTY, Observable } from 'rxjs';
import { ProfileService } from '../profile/profile.service';
import { Profile } from '../_models/profile';
import { catchError } from 'rxjs/operators';
import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class ProfileResolver implements Resolve<Profile> {
  constructor(private storageService:StorageService,private router: Router, public profileService: ProfileService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Profile> {

    let reqUserId = this.storageService.getUser()['id'] || 0;
    console.log("anajrb atay", reqUserId);
    
    return this.profileService.getOneByUsernameBy(reqUserId, route.paramMap.get('username')).pipe(catchError(() => {
      this.router.navigateByUrl(`/${route.paramMap.get('username')}/404`, {skipLocationChange: true})
      return EMPTY;
    }));
 }
}
