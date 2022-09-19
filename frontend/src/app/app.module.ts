import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';

import { faBars as fasBars } from '@fortawesome/free-solid-svg-icons';
import { faCirclePlus as fasCirclePlus } from '@fortawesome/free-solid-svg-icons';
import { faCircleArrowRight as fasCircleArrowRight } from '@fortawesome/free-solid-svg-icons';
import { faCircleArrowLeft as fasCircleArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { faRightFromBracket as fasRightFromBracket } from '@fortawesome/free-solid-svg-icons';
import { faGears as fasGears } from '@fortawesome/free-solid-svg-icons';
import { faBell as fasBell } from '@fortawesome/free-solid-svg-icons';
import { faMessage as fasMessage } from '@fortawesome/free-solid-svg-icons';
import { faBookmark as fasBookmark } from '@fortawesome/free-solid-svg-icons';
import { faImages as fasImages } from '@fortawesome/free-solid-svg-icons';
import { faIdCardClip as fasIdCardClip } from '@fortawesome/free-solid-svg-icons';
import { faMagnifyingGlass as fasMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import { faArrowLeft as fasArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { faThumbsUp as fasThumbsUp } from '@fortawesome/free-solid-svg-icons';
import { faBarsStaggered as fasBarsStaggered } from '@fortawesome/free-solid-svg-icons';
import { faEnvelope as fasEnvelope } from '@fortawesome/free-solid-svg-icons';
import { faHashtag as fasHashtag } from '@fortawesome/free-solid-svg-icons';
import { faUsers as fasUsers } from '@fortawesome/free-solid-svg-icons';
import { faGauge as fasGauge } from '@fortawesome/free-solid-svg-icons';
import { faHouse as fasHouse } from '@fortawesome/free-solid-svg-icons';
import { faBook as fasBook } from '@fortawesome/free-solid-svg-icons';
import { faInfo as fasInfo } from '@fortawesome/free-solid-svg-icons';

import { faFacebook as fabFacebook} from '@fortawesome/free-brands-svg-icons';
import { faTwitter as fabTwitter } from '@fortawesome/free-brands-svg-icons';
import { faInstagram as fabInstagram } from '@fortawesome/free-brands-svg-icons';
import { faLinkedin as fabLinkedin } from '@fortawesome/free-brands-svg-icons';
import { faGithub as fabGithub } from '@fortawesome/free-brands-svg-icons';
import { faYoutube as fabYoutube } from '@fortawesome/free-brands-svg-icons';
import { faDiscord as fabDiscord } from '@fortawesome/free-brands-svg-icons';
import { faYandexInternational as fabYandexInternational } from '@fortawesome/free-brands-svg-icons';
import { faCloudflare as fabCloudflare } from '@fortawesome/free-brands-svg-icons';
import { faSearchengin as fabSearchengin } from '@fortawesome/free-brands-svg-icons';
import { faGoogle as fabGoogle } from '@fortawesome/free-brands-svg-icons';
import { faChartSimple as fasChartSimple } from '@fortawesome/free-solid-svg-icons';
import { faRectangleAd as fasRectangleAd } from '@fortawesome/free-solid-svg-icons';
import { faGlobe as fasGlobe } from '@fortawesome/free-solid-svg-icons';


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
import { ProfileLayoutComponent } from './layouts/profile-layout/profile-layout.component';
import { BackToTopComponent } from './shared/back-to-top/back-to-top.component';
import { MemeComponent } from './site/meme/meme.component';
import { ProfileDropdownComponent } from './shared/profile-dropdown/profile-dropdown.component';
import { NgChartsModule } from 'ng2-charts';
import { UseTermsComponent } from './site/use-terms/use-terms.component';
import { PrivacyPolicyComponent } from './site/privacy-policy/privacy-policy.component';
import { ScrollSpyDirective } from './documentation/scroll-spy.directive';


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
    MemeComponent,
    ProfileDropdownComponent,
    UseTermsComponent,
    PrivacyPolicyComponent,
    ScrollSpyDirective,  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    NgbModule,
    FontAwesomeModule,
    AppRoutingModule,
    SwiperModule,
    NgChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
  constructor(library: FaIconLibrary) {
    library.addIcons(fabFacebook, fabTwitter, fabInstagram, fabLinkedin, fabGithub, fabYoutube, fabDiscord,
      fasBars, fasCirclePlus, fasCircleArrowRight, fasCircleArrowLeft,
      fasRightFromBracket, fasGears, fasBell, fasMessage, fasBookmark, fasImages, fasIdCardClip,
      fasHouse, fasBook, fasInfo, fasGlobe,
      fasMagnifyingGlass, fasArrowLeft, fasThumbsUp, fasBarsStaggered, fasEnvelope, fasHashtag, fasUsers, fasGauge,
      fabYandexInternational, fabCloudflare, fabSearchengin, fabGoogle, fasChartSimple, fasRectangleAd
      );

  }
}
