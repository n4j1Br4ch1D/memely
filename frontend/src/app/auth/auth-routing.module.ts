import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ResetPasswordTokenComponent } from './reset-password-token/reset-password-token.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignOutComponent } from './sign-out/sign-out.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  { 
    path: '',
    // component: SignInComponent,
    children: [
      { path: '', component: SignInComponent },
      { path: 'sign-in', component: SignInComponent },
      { path: 'sign-up', component: SignUpComponent },
      { path: 'sign-out', component: SignOutComponent },
      { path: 'forgot-password', component: ForgotPasswordComponent },
      { path: 'reset-password-token', component: ResetPasswordTokenComponent },
      { path: 'reset-password-token/:token', component: ResetPasswordTokenComponent },
      { path: 'reset-password', component: ResetPasswordComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
