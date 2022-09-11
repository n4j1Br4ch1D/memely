import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { SearcherComponent } from './site/searcher/searcher.component';
import { ViewerComponent } from './site/viewer/viewer.component';
import { AboutComponent } from './site/about/about.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './site/home/home.component';
import { PagenotfoundComponent } from './errors/pagenotfound/pagenotfound.component';
import { ProfileComponent } from './profile/profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContactComponent } from './site/contact/contact.component';
import { DocumentationComponent } from './documentation/documentation.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { DashboardLayoutComponent } from './layouts/dashboard-layout/dashboard-layout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearcherComponent,
    ViewerComponent,
    AboutComponent,
    FooterComponent,
    HomeComponent,
    PagenotfoundComponent,
    ProfileComponent,
    DashboardComponent,
    ContactComponent,
    DocumentationComponent,
    MainLayoutComponent,
    DashboardLayoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
