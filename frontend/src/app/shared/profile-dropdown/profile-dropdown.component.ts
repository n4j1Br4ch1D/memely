import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-profile-dropdown',
  templateUrl: './profile-dropdown.component.html',
  styleUrls: ['./profile-dropdown.component.scss'],
})
export class ProfileDropdownComponent implements OnInit {
  signedInUser: any;
  signedIn!: boolean;
  isAdmin!: boolean;
  constructor(
    private router: Router,
    private storageService: StorageService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.signedInUser = this.storageService.getUser();
    this.signedIn = this.storageService.isSignedIn();
    this.isAdmin = this.storageService.isAdmin();
  }

  signOut(): void {
    this.authService.signOut().subscribe({
      next: (res) => {
        console.log(res);
        this.storageService.clean();
        this.router.navigate(['/auth/sign-out']);
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
