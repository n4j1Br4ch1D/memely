import { Component, OnInit, Output, EventEmitter, ViewEncapsulation } from '@angular/core';
import { SwiperComponent } from "swiper/angular";

// import Swiper core and required modules
import SwiperCore, { Navigation, Pagination } from "swiper";
import { TagService } from 'src/app/_services/tag.service';
// install Swiper modules
SwiperCore.use([Navigation, Pagination]);

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class SearcherComponent implements OnInit {
  constructor(private tagService:TagService) {}
  keyword = 'programmer'
  tags:any;
  @Output() emitter: EventEmitter<string> = new EventEmitter<string>();

  emitKeyword(keyword: string) {
    // console.log('sending', keyword);
    this.emitter.emit(keyword);
  }

  emitTag(tag: string) {
    console.log('sending tag', tag);
    this.emitter.emit(tag);
  }

  ngOnInit(): any {
    this.tagService.getAll().subscribe(data=>{
      let res:any =data;
      // console.log(data);
      
      this.tags = res['content'];
    })
    this.emitKeyword('funny');
  }
}