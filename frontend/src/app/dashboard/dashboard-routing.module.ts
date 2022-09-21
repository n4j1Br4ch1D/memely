import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommentsComponent } from './comments/comments.component';
import { ContactsComponent } from './contacts/contacts.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { MemesComponent } from './memes/memes.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ReactionsComponent } from './reactions/reactions.component';
import { SettingsComponent } from './settings/settings.component';
import { StoriesComponent } from './stories/stories.component';
import { TagsComponent } from './tags/tags.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: '', component: DashboardComponent },
      { path: 'profiles', component: ProfilesComponent },
      { path: 'memes', component: MemesComponent },
      { path: 'tags', component: TagsComponent },
      { path: 'reactions', component: ReactionsComponent },
      { path: 'comments', component: CommentsComponent },
      { path: 'stories', component: StoriesComponent },
      { path: 'favorites', component: FavoritesComponent },
      { path: 'contacts', component: ContactsComponent },
      { path: 'notifications', component: NotificationsComponent },
      { path: 'settings', component: SettingsComponent },


      //user
      //meme
      //tag
      //reaction
      //contact

    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}
