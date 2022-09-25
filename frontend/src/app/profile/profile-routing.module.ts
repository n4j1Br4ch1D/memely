import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyCommentsComponent } from './my-comments/my-comments.component';
import { MyContactsComponent } from './my-contacts/my-contacts.component';
import { MyFavoritesComponent } from './my-favorites/my-favorites.component';
import { MyFollowersComponent } from './my-followers/my-followers.component';
import { MyFollowingsComponent } from './my-followings/my-followings.component';
import { MyMemesComponent } from './my-memes/my-memes.component';
import { MyMentionsComponent } from './my-mentions/my-mentions.component';
import { MyMessagesComponent } from './my-messages/my-messages.component';
import { MyNotificationsComponent } from './my-notifications/my-notifications.component';
import { MyReactionsComponent } from './my-reactions/my-reactions.component';
import { MyReportsComponent } from './my-reports/my-reports.component';
import { MySettingsComponent } from './my-settings/my-settings.component';
import { NewMemeComponent } from './new-meme/new-meme.component';

const routes: Routes = [
  {
    path: '',
    // component: ProfileComponent,
    children: [
      { path: '', component: MyMemesComponent},
      { path: 'memes', component: MyMemesComponent},
      { path: 'favorites', component: MyFavoritesComponent },
      { path: 'reactions', component: MyReactionsComponent },
      { path: 'comments', component: MyCommentsComponent },
      { path: 'mentions', component: MyMentionsComponent },
      { path: 'followings', component: MyFollowingsComponent },
      { path: 'followers', component: MyFollowersComponent },
      { path: 'messages', component: MyMessagesComponent },
      { path: 'contacts', component: MyContactsComponent },
      { path: 'reports', component: MyReportsComponent },
      { path: 'notifications', component: MyNotificationsComponent },
      { path: 'settings', component: MySettingsComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
