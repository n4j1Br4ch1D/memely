import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MemeService } from 'src/app/_services/meme.service';

@Component({
  selector: 'app-my-reports',
  templateUrl: './my-reports.component.html',
  styleUrls: ['./my-reports.component.scss']
})
export class MyReportsComponent implements OnInit {
  currentProfileId: any;
  memes:any = [];
  constructor(private memeService:MemeService,  private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.currentProfileId = this.route.snapshot.data['profile']['id'];
    this.memeService.getUserReports(this.currentProfileId).subscribe(data=>{
      this.memes = data;
    })
  }
}
