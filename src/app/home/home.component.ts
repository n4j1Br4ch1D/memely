import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  keyword = "";
  send(keyword :string){
    console.log('from sending', keyword);
    this.keyword = keyword;
  }
  ngOnInit(): void {
  }

}
