import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';


import { faCircleArrowRight as fasCircleArrowRight } from '@fortawesome/free-solid-svg-icons';
import { faCircleArrowLeft as fasCircleArrowLeft } from '@fortawesome/free-solid-svg-icons';

import { faFacebook as fabFacebook} from '@fortawesome/free-brands-svg-icons';
import { faTwitter as fabTwitter } from '@fortawesome/free-brands-svg-icons';
import { faInstagram as fabInstagram } from '@fortawesome/free-brands-svg-icons';
import { faLinkedin as fabLinkedin } from '@fortawesome/free-brands-svg-icons';
import { faGithub as fabGithub } from '@fortawesome/free-brands-svg-icons';
import { faYoutube as fabYoutube } from '@fortawesome/free-brands-svg-icons';
import { faDiscord as fabDiscord } from '@fortawesome/free-brands-svg-icons';

import { AppRoutingModule } from './app-routing.module';
import { SwiperModule } from 'swiper/angular';

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
import { BackToTopComponent } from './shared/back-to-top/back-to-top.component';
import { MemeComponent } from './site/meme/meme.component';


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
    BackToTopComponent,
    MemeComponent,  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    NgbModule,
    FontAwesomeModule,
    AppRoutingModule,
    SwiperModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
  constructor(library: FaIconLibrary) {
    library.addIcons(fabFacebook, fabTwitter, fabInstagram, fabLinkedin, fabGithub, fabYoutube, fabDiscord,
      fasCircleArrowRight, fasCircleArrowLeft);

  }
}
