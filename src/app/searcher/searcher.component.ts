import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { fromFetch } from 'rxjs/fetch';
@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css'],
})
export class SearcherComponent implements OnInit {
  constructor() {}

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
      next: (result: any) => console.log(result),
      complete: () => console.log(keyword),
    });
  }


  ngOnInit(): any {
    this.search('programmer');
  }
}
