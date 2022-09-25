import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-favorites',
  templateUrl: './my-favorites.component.html',
  styleUrls: ['./my-favorites.component.scss']
})
export class MyFavoritesComponent implements OnInit {
  currentProfileId: any;
  memes:any = [];
  constructor(private memeService:MemeService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.memeService.getUserFavorites(this.currentProfileId).subscribe(data=>{
      this.memes = data;
    })
  }
}
