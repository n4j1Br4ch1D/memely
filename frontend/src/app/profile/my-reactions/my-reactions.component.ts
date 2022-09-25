import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-reactions',
  templateUrl: './my-reactions.component.html',
  styleUrls: ['./my-reactions.component.scss']
})
export class MyReactionsComponent implements OnInit {
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
