import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MemeMaker } from 'src/app/_interfaces/meme-maker';

@Component({
  selector: 'app-new-meme',
  templateUrl: './new-meme.component.html',
  styleUrls: ['./new-meme.component.scss']
})
export class NewMemeComponent implements OnInit {
  @Input() status!: boolean;
  title = '';
  description = '';
  tags = '';
  active = 1;

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }

  topText: string = "This is top Text";
  bottomText: string = "This is bottom Text";
  imageName: string = "Surprised Pikachu";
  color: string = "#000";
  imageNameList: string[] = ["Surprised Pikachu"];
  imageFileNameList: string[] = ["surprised_pikachu.png"];


  changeImage(){
      var valueOfSearch: string = "";
      for(var i = 0; i < this.imageNameList.length; i++){
          if(this.imageNameList[i] === this.imageName){
              valueOfSearch = this.imageFileNameList[i];
          }
      }
      var whole: string = "assets/img/meme_templates/" + valueOfSearch;
      return whole;
  }

  images :any = [];

  drawOnCanvas({ imageUrl, textOnTop, textOnBottom }: MemeMaker) {
    try {
      const image = new Image();
      image.src = imageUrl;
      image.setAttribute("crossOrigin", "anonymous");
      image.onload = loadEvent => {
        const imageElement = (loadEvent as any).path[0] as HTMLImageElement;
        const { width, height } = imageElement;
        const canvas = document.createElement("canvas");
        const context : any = canvas.getContext("2d");
        canvas.width = width;
        canvas.height = height;
        context.drawImage(imageElement, 0, 0);
        context.font = `${width / 6}px Calibri`;
        context.textAlign = "center";
        context.fillStyle = "white";
        context.fillText(textOnTop.toUpperCase(), width / 2.3, 300);
        context.fillText(textOnBottom.toLowerCase(), width / 2.3, height - 100);
        const dataURL:any = canvas.toDataURL();
        this.images.push(dataURL);
      };
    } catch (error) {
      console.log(error);
    }
  }

}


