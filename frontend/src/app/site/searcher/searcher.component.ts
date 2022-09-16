import { Component, OnInit, Output, EventEmitter, ViewEncapsulation } from '@angular/core';
import { SwiperComponent } from "swiper/angular";

// import Swiper core and required modules
import SwiperCore, { Navigation, Pagination } from "swiper";
// install Swiper modules
SwiperCore.use([Navigation, Pagination]);

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class SearcherComponent implements OnInit {
  constructor() {}
  keyword = 'programmer'
  @Output() emitter: EventEmitter<string> = new EventEmitter<string>();

  emit(keyword: string) {
    console.log('sending', keyword);
    this.emitter.emit(keyword);
  }

  ngOnInit(): any {
    this.emit('programmer');
  }
}