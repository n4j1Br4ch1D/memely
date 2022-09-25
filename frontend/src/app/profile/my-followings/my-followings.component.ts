import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-my-followings',
  templateUrl: './my-followings.component.html',
  styleUrls: ['./my-followings.component.scss']
})
export class MyFollowingsComponent implements OnInit {
  currentProfileId: any;
  following:any = [];
  constructor(private profileService:ProfileService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.profileService.getFollowing(this.currentProfileId).subscribe(data=>{
      this.following = data;
    })
  }
}
