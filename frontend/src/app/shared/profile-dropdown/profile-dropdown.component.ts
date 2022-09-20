import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-dropdown',
  templateUrl: './profile-dropdown.component.html',
  styleUrls: ['./profile-dropdown.component.scss']
})
export class ProfileDropdownComponent implements OnInit {

  signedIn:boolean= true;
  isAdmin:boolean= true;
  constructor() { }

  ngOnInit(): void {
  }

}
