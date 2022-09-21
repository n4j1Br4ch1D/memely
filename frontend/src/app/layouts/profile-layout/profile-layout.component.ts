import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profile } from 'src/app/_models/profile';
import { ProfileService } from 'src/app/profile/profile.service';
import { AuthService } from 'src/app/_services/auth.service';

@Component({
  selector: 'app-profile-layout',
  templateUrl: './profile-layout.component.html',
  styleUrls: ['./profile-layout.component.scss']
})
export class ProfileLayoutComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private profileService: ProfileService,
     private route: ActivatedRoute) { }
  
  currentProfile:any;
  signedInUser!:Profile;

  get isProfile():boolean{
  if (this.currentProfile.id==this.signedInUser?.id) {
    return true;
  }
   return false;
  }

  ngOnInit(): void {
    this.signedInUser = this.authService.getSignedInUser();
    this.currentProfile = this.route.snapshot.data['profile'];
  }

}
