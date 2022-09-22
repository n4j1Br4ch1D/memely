import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class GuestGuard implements CanActivate {

  constructor(
    private storageService: StorageService,
    private router: Router
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.storageService.isSignedIn()){
      if(this.storageService.isAdmin()){
       this.router.navigate(['/dashboard'])
       return true;
      }
      else{
      this.router.navigate([this.storageService.getUser()['id']]) 
      return false;
      }
    }
    return true;
  }
  
}
