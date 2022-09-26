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
import { environment } from 'src/environments/environment';

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
  @Input() tag: string = '';


  memes:any =[];
  memeImgPath = environment.imgUrl+'memes/';
  search(keyword: string): any {
    this.memeService.search(keyword).subscribe({
      next: (result: any) => {
        this.memes = result;
        console.log(result.results);
      },
      complete: () => console.log(keyword),
    });
  }
  filterTag(tag: string): any {
    this.memeService.getAllByTag(tag).subscribe({
      next: (result: any) => {
        console.log("foooor Tag "+tag, result);
        this.memes = result;
        console.log("what", this.memes);
      },
      complete: () => console.log("complete", this.memes),
    });
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
    this.search(this.keyword);
    this.filterTag(this.tag);

  }

  public masonryOptions: NgxMasonryOptions = {
    gutter: 0,
    
  };
}
