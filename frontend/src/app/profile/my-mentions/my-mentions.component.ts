import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MentionService } from 'src/app/_services/mention.service';

@Component({
  selector: 'app-my-mentions',
  templateUrl: './my-mentions.component.html',
  styleUrls: ['./my-mentions.component.scss']
})
export class MyMentionsComponent implements OnInit {
  currentProfileId: any;
  mentions:any = [];
  constructor(private mentionService:MentionService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.mentionService.getuserMentions(this.currentProfileId).subscribe(data=>{
      this.mentions = data;
    })
  }
}

