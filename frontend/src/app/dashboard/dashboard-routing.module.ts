import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdsComponent } from './ads/ads.component';
import { ChatsComponent } from './chats/chats.component';
import { CommentsComponent } from './comments/comments.component';
import { ContactsComponent } from './contacts/contacts.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { MemesComponent } from './memes/memes.component';
import { MentionsComponent } from './mentions/mentions.component';
import { MenusComponent } from './menus/menus.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { PagesComponent } from './pages/pages.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ReactionsComponent } from './reactions/reactions.component';
import { ReportsComponent } from './reports/reports.component';
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
      { path: 'mentions', component: MentionsComponent },
      { path: 'stories', component: StoriesComponent },
      { path: 'favorites', component: FavoritesComponent },
      { path: 'chats', component: ChatsComponent },
      { path: 'notifications', component: NotificationsComponent },
      { path: 'contacts', component: ContactsComponent },
      { path: 'reports', component: ReportsComponent },
      { path: 'menus', component: MenusComponent },
      { path: 'pages', component: PagesComponent },
      { path: 'ads', component: AdsComponent },
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
