import { Component, Input, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_services/auth.service';

@Component({
  selector: 'app-profile-dropdown',
  templateUrl: './profile-dropdown.component.html',
  styleUrls: ['./profile-dropdown.component.scss']
})
export class ProfileDropdownComponent implements OnInit {
  signedInUser: any;
  signedIn!:boolean;
  isAdmin!:boolean;
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.signedInUser = this.authService.getSignedInUser();
    this.signedIn = (!!this.signedInUser);
    this.isAdmin = (this.signedInUser['role']==='admin');

  }

}
