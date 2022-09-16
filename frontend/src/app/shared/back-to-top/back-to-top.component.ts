import { ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-back-to-top',
  templateUrl: './back-to-top.component.html',
  styleUrls: ['./back-to-top.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class BackToTopComponent implements OnInit {

  @Output() scrollToTop = new EventEmitter<void>();

  constructor() { }

  onScrollToTop(): void {
    this.scrollToTop.emit();
  }
  ngOnInit(): void {
  }

}
