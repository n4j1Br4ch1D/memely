import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-my-settings',
  templateUrl: './my-settings.component.html',
  styleUrls: ['./my-settings.component.scss'],
})
export class MySettingsComponent implements OnInit {
  authUser: any;
  constructor(
    private storageService: StorageService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.authUser = this.storageService.getUser();
    
  }
}
