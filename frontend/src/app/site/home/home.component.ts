import { DOCUMENT, ViewportScroller } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { fromEvent, map, Observable } from 'rxjs';

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
  
  readonly showScroll$: Observable<boolean> = fromEvent(
    this.document,
    'scroll'
  ).pipe(
    map(() => this.viewport.getScrollPosition()?.[1] > 0)
  );

  constructor(@Inject(DOCUMENT) private readonly document: Document, private readonly viewport: ViewportScroller) { }
}


