import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-memes',
  templateUrl: './my-memes.component.html',
  styleUrls: ['./my-memes.component.scss']
})
export class MyMemesComponent implements OnInit {
  currentProfileId: any;
  memes:any = [];
  constructor(private memeService:MemeService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.memeService.getUserMemes(this.currentProfileId).subscribe(data=>{
      this.memes = data;
    })
  }
}
