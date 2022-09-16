import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { NewMemeComponent } from './new-meme/new-meme.component';
import { MyMemesComponent } from './my-memes/my-memes.component';
import { MyFavoritesComponent } from './my-favorites/my-favorites.component';
import { MyReactionsComponent } from './my-reactions/my-reactions.component';
import { MyFollowingsComponent } from './my-followings/my-followings.component';
import { MyFollowersComponent } from './my-followers/my-followers.component';
import { MyNotificationsComponent } from './my-notifications/my-notifications.component';
import { MySettingsComponent } from './my-settings/my-settings.component';


@NgModule({
  declarations: [
    NewMemeComponent,
    MyMemesComponent,
    MyFavoritesComponent,
    MyReactionsComponent,
    MyFollowingsComponent,
    MyFollowersComponent,
    MyNotificationsComponent,
    MySettingsComponent
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule
  ]
})
export class ProfileModule { }
