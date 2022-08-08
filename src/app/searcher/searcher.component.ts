import { Component, OnInit } from '@angular/core';
import { fromFetch } from 'rxjs/fetch';
import { switchMap, of, catchError } from 'rxjs';
@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
   const apiKey$ = 'AIzaSyA0v010oX8a0ApcRYmAeN-omDVGDitxPT8';
   const pageLimit$ = 1;

  const data$ = fromFetch(`https://tenor.googleapis.com/v2/search?q=excited&key=${apiKey$}&limit=${pageLimit$}`).pipe(
  switchMap(response => {
    if (response.ok) {
      // OK return data
      return response.json();
    } else {
      // Server is returning a status requiring the client to try something else.
      return of({ error: true, message: `Error ${ response.status }` });
    }
  }),
  catchError(err => {
    // Network or other error, handle appropriately
    console.error(err);
    return of({ error: true, message: err.message })
  })
);

data$.subscribe({
  next: result => console.log(result),
  complete: () => console.log('done')
});
  }

}




