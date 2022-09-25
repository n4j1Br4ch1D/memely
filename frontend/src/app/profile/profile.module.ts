import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileRoutingModule } from './profile-routing.module';
import { MyMemesComponent } from './my-memes/my-memes.component';
import { MyFavoritesComponent } from './my-favorites/my-favorites.component';
import { MyReactionsComponent } from './my-reactions/my-reactions.component';
import { MyFollowingsComponent } from './my-followings/my-followings.component';
import { MyFollowersComponent } from './my-followers/my-followers.component';
import { MyNotificationsComponent } from './my-notifications/my-notifications.component';
import { MySettingsComponent } from './my-settings/my-settings.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MyCommentsComponent } from './my-comments/my-comments.component';


@NgModule({
  declarations: [
    MyMemesComponent,
    MyFavoritesComponent,
    MyReactionsComponent,
    MyFollowingsComponent,
    MyFollowersComponent,
    MyNotificationsComponent,
    MySettingsComponent,
    MyCommentsComponent
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    FormsModule,
    NgbModule,
    FontAwesomeModule
  ]
})
export class ProfileModule { }
