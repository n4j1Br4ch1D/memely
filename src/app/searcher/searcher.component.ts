import { Component, OnInit, Output, EventEmitter } from '@angular/core';
@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css'],
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
