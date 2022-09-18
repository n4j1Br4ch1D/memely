import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyFavoritesComponent } from './my-favorites/my-favorites.component';
import { MyFollowersComponent } from './my-followers/my-followers.component';
import { MyFollowingsComponent } from './my-followings/my-followings.component';
import { MyMemesComponent } from './my-memes/my-memes.component';
import { MyNotificationsComponent } from './my-notifications/my-notifications.component';
import { MyReactionsComponent } from './my-reactions/my-reactions.component';
import { MySettingsComponent } from './my-settings/my-settings.component';
import { NewMemeComponent } from './new-meme/new-meme.component';

const routes: Routes = [
  {
    path: '',
    // component: ProfileComponent,
    children: [
      { path: 'profile/:username', component: MyMemesComponent },
      { path: 'memes', component: MyMemesComponent},
      { path: 'favorites', component: MyFavoritesComponent },
      { path: 'reactions', component: MyReactionsComponent },
      { path: 'Followings', component: MyFollowingsComponent },
      { path: 'followers', component: MyFollowersComponent },
      { path: 'notifications', component: MyNotificationsComponent },
      { path: 'settings', component: MySettingsComponent },
      { path: 'memes/new', component: NewMemeComponent}


    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
