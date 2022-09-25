import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-comments',
  templateUrl: './my-comments.component.html',
  styleUrls: ['./my-comments.component.scss']
})
export class MyCommentsComponent implements OnInit {
  currentProfileId: any;
  memes:any = [];
  constructor(private memeService:MemeService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.memeService.getUserReactions(this.currentProfileId).subscribe(data=>{
      this.memes = data;
    })
  }
}
