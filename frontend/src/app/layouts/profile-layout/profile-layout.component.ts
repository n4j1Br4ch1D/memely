import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profile } from 'src/app/_models/profile';
import { ProfileService } from 'src/app/profile/profile.service';

@Component({
  selector: 'app-profile-layout',
  templateUrl: './profile-layout.component.html',
  styleUrls: ['./profile-layout.component.scss']
})
export class ProfileLayoutComponent implements OnInit {

  constructor(private profileService: ProfileService,
     private route: ActivatedRoute, 
     private router: Router) { }
  private profileUsername!: string;
  currentProfile!:Profile;
  logedInUser:Profile = {
    id: 1,
    name: 'Najib Rachid',
    username: 'najib-rachid',
    email: 'najib@anmoon.ma'
  }

  get isProfile():boolean{
  if (this.currentProfile.id==this.logedInUser.id) {
    return true;
  }
   return false;
  }
  getProfile(id: string): void {
    this.profileService.get(id)  //username
      .subscribe({
        next: (data) => {
          this.currentProfile = data;
        },
        error: (e) =>
         this.router.navigateByUrl(`/${this.profileUsername}/404`, {skipLocationChange: true})
      });
  }

  ngOnInit(): void {
    this.route.params
      .subscribe(params => {
        this.profileUsername = params['username'];        
      }
    );
    this.getProfile(this.profileUsername);
  }

}
