import {
  AfterViewInit,
  ViewChild,
  Component,
  DoCheck,
  Input,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { fromFetch } from 'rxjs/fetch';
@Component({
  selector: 'app-viewer',
  templateUrl: './viewer.component.html',
  styleUrls: ['./viewer.component.css'],
})
export class ViewerComponent implements OnInit {
  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe( params => console.log("params:", params) );
  }
  @Input() keyword: string = '';
  items = [];

  fetchMemes(keyword: string): any {
    const apiKey$ = 'AIzaSyA0v010oX8a0ApcRYmAeN-omDVGDitxPT8';
    const pageLimit$ = 40;
    const url$ = `https://tenor.googleapis.com/v2/search?q=${keyword}&key=${apiKey$}&limit=${pageLimit$}`;
    const data$ = fromFetch(url$, {
      selector: (response) => response.json(),
    });
    return data$;
  }

  search(keyword: string): any {
    this.fetchMemes(keyword).subscribe({
      next: (result: any) => {
        this.items = result.results;
        console.log(result.results);
      },
      complete: () => console.log(keyword),
    });
  }

  ngOnInit(): void {
    this.search(this.keyword);
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log(1);
    console.log(changes);
    this.search(this.keyword);
  }


}
