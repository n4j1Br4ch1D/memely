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
     private route: ActivatedRoute) { }
   currentProfile:any;
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

  ngOnInit(): void {
    this.currentProfile = this.route.snapshot.data['profile'];
  }

}
