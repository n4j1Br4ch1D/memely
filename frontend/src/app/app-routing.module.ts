import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './site/home/home.component';
import { AboutComponent } from './site/about/about.component';
import { PagenotfoundComponent } from './errors/pagenotfound/pagenotfound.component';
import { ContactComponent } from './site/contact/contact.component';
import { DocumentationComponent } from './documentation/documentation.component';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';
import { DashboardLayoutComponent } from './layouts/dashboard-layout/dashboard-layout.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { ProfileLayoutComponent } from './layouts/profile-layout/profile-layout.component';
import { MemeComponent } from './site/meme/meme.component';
import { UseTermsComponent } from './site/use-terms/use-terms.component';
import { PrivacyPolicyComponent } from './site/privacy-policy/privacy-policy.component';
const routes: Routes = [
  // Site
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: '', component: HomeComponent, title: 'Home - Memely' },
      { path: 'memes/:keyword', component: HomeComponent, title: 'Memes - Memely' },
      { path: 'meme', component: MemeComponent, title: 'Meme - Memely' },
      { path: 'about', component: AboutComponent, title: 'About - Memely' },
      { path: 'contact', component: ContactComponent, title: 'Contact - Memely' },
      { path: 'use-terms', component: UseTermsComponent, title: 'Use Terms - Memely' },
      { path: 'privacy-policy', component: PrivacyPolicyComponent, title: 'Privacy Policy - Memely' },
    ],
  },

  // Documentation
  {
    path: 'documentation',
    component: MainLayoutComponent,
    children: [
      { path: '', component: DocumentationComponent }, ////$page
    ],
  },

  // Auth
  {
    path: 'auth',
    component: MainLayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '',
        pathMatch: 'full',
      },
      {
        path: '',
        loadChildren: () =>
          import('./auth/auth.module').then((m) => m.AuthModule),
      },
    ],
  },

  // Profile
  {
    path: 'profile',
    component: ProfileLayoutComponent,
    children: [
      // {
      //   path: '',
      //   redirectTo: '',
      //   pathMatch: 'full'
      // },
      {
        path: '',
        loadChildren: () =>
          import('./profile/profile.module').then((m) => m.ProfileModule),
      },
    ],
  },

  // Dashboard
  {
    path: 'dashboard',
    component: DashboardLayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full',
      },
      {
        path: '',
        loadChildren: () =>
          import('./dashboard/dashboard.module').then((m) => m.DashboardModule),
      },
    ],
  },

  // Errors
  // 401
  // 403
  // 500 /*
  { 
    path: '**', 
    pathMatch: 'full',   
    component: MainLayoutComponent,
   children: [
    {
      path: '',
      component: PagenotfoundComponent
    }
   ],
 },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
