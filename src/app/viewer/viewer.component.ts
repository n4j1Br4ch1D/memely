import { AfterViewInit, ViewChild, Component,  DoCheck, Input, OnInit } from '@angular/core';
import { fromFetch } from 'rxjs/fetch';
@Component({
  selector: 'app-viewer',
  templateUrl: './viewer.component.html',
  styleUrls: ['./viewer.component.css']
})
export class ViewerComponent implements OnInit {

  constructor() { }
  @Input() keyword :string | undefined;
  items = [];

  fetchMemes(keyword: String): any {
    const apiKey$ = 'AIzaSyA0v010oX8a0ApcRYmAeN-omDVGDitxPT8';
    const pageLimit$ = 5;
    const url$ = `https://tenor.googleapis.com/v2/search?q=${keyword}&key=${apiKey$}&limit=${pageLimit$}`;
    const data$ = fromFetch(url$, {
      selector: (response) => response.json(),
    });
    return data$;
  }

  search(keyword: String): any {
    this.fetchMemes(keyword).subscribe({
      next: (result: any) => {this.items= result.results; console.log(result.results)},
      complete: () => console.log(keyword),
    });
  }

  ngOnInit(): void {
    this.search('programmer');
  }
  
}
