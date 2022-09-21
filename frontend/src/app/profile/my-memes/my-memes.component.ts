import { Component, OnInit } from '@angular/core';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-memes',
  templateUrl: './my-memes.component.html',
  styleUrls: ['./my-memes.component.scss']
})
export class MyMemesComponent implements OnInit {

  constructor(private memeService: MemeService) { }

  ngOnInit(): void {
    this.memeService.getAll().subscribe(data=>{
      console.log("my memes", data);
      
    })
  }

}
