import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-documentation',
  templateUrl: './documentation.component.html',
  styleUrls: ['./documentation.component.scss']
})
export class DocumentationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  currentSection = 'get-started';

  onSectionChange(sectionId: string) {
    this.currentSection = sectionId;
  }

  scrollTo(section: string) {    
    document?.querySelector('#' + section)?.scrollIntoView()
    this.currentSection = section;
  }
}
