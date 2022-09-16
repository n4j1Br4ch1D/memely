import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-documentation',
  templateUrl: './documentation.component.html',
  styleUrls: ['./documentation.component.css']
})
export class DocumentationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @HostListener('window:scroll', ['$event'])
  onWindowScroll($event: any) {
      console.log("scrolling...");
  }

  myColor = 'red';

  onScroll(element: { scrollTop: number; }) {
   console.log("scrolling...");
   console.log(element.scrollTop)
 
   if (element.scrollTop > 100) {
     this.myColor = 'blue';
   }
   
  }

}
