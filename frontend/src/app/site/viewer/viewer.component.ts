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
import { NgxMasonryOptions } from 'ngx-masonry';
import { MemeService } from 'src/app/_services/meme.service';
import { LoadingBarComponent } from '@ngx-loading-bar/core';

type MemeType = {
  id: Number;
  content: any;
  title: string;
  img: string;
};

@Component({
  selector: 'app-viewer',
  templateUrl: './viewer.component.html',
  styleUrls: ['./viewer.component.scss'],
})
export class ViewerComponent implements OnInit {
  constructor(private route: ActivatedRoute, private memeService: MemeService) {
    // this.route.params.subscribe( params => console.log("params:", params) );
  }
  @Input() keyword: string = '';
  memes:any =[];

  // fetchMemes(keyword: string): any {
  //   const apiKey$ = 'AIzaSyA0v010oX8a0ApcRYmAeN-omDVGDitxPT8';
  //   const pageLimit$ = 40;
  //   const url$ = `https://tenor.googleapis.com/v2/search?q=${keyword}&key=${apiKey$}&limit=${pageLimit$}`;
  //   const data$ = fromFetch(url$, {
  //     selector: (response) => response.json(),
  //   });
  //   return data$;
  // }

  search(keyword: string): any {
    // this.fetchMemes(keyword).subscribe({
    //   next: (result: any) => {
    //     this.memes = result.results;
    //     console.log(result.results);
    //   },
    //   complete: () => console.log(keyword),
    // });
  }

  ngOnInit(): void {
    // this.search(this.keyword);
    this.memeService.getAll().subscribe(data=>{
      console.log("datao", data);
      let res:any =data;
      this.memes = res.content;
      console.log(this.memes);
      
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log(1);
    console.log(changes);
    this.search(this.keyword);
  }

  public masonryOptions: NgxMasonryOptions = {
    gutter: 0,
    
  };
}
