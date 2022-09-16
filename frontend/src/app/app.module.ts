import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SwiperModule } from 'swiper/angular';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { SearcherComponent } from './site/searcher/searcher.component';
import { ViewerComponent } from './site/viewer/viewer.component';
import { AboutComponent } from './site/about/about.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { HomeComponent } from './site/home/home.component';
import { PagenotfoundComponent } from './errors/pagenotfound/pagenotfound.component';
import { DashboardComponent } from './dashboard/dashboard/dashboard.component';
import { ContactComponent } from './site/contact/contact.component';
import { DocumentationComponent } from './documentation/documentation.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { DashboardLayoutComponent } from './layouts/dashboard-layout/dashboard-layout.component';
import { ProfileLayoutComponent } from './layout/profile-layout/profile-layout.component';

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
    DashboardComponent,
    ContactComponent,
    DocumentationComponent,
    MainLayoutComponent,
    DashboardLayoutComponent,
    ProfileLayoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    SwiperModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  // declarations: [AppComponent],
})
export class AppModule { }






