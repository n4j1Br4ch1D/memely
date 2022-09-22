import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';
import { StorageService } from 'src/app/_services/storage.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };
  isSignedIn = false;
  isSignFailed = false;
  errorMessage = '';
  role!: string;

  constructor(private authService: AuthService, private storageService: StorageService, private router: Router) { }

  ngOnInit(): void {

    // this.authService.signIn('najib', 'password').subscribe( data =>{
    //   console.log("signIn", data);
    // });

    if (this.storageService.isSignedIn()) {
      this.isSignedIn = true;
      this.role = this.storageService.getUser().role;
    }
  }



  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.signIn(username, password).subscribe({
      next: data => {
        console.log("my data is", data);
        
        this.storageService.saveUser(data);
        this.isSignFailed = false;
        this.isSignedIn = true;;
        this.role = this.storageService.getUser().role;     
        if (this.role == "ROLE_ADMIN") {          
          this.router.navigate(['dashboard']);
        } else {
          this.router.navigate([`/${this.storageService.getUser().id}`]);
        }
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignFailed = true;
      }
    });
  }
}
