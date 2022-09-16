import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactsComponent } from './contacts/contacts.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MemesComponent } from './memes/memes.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ReactionsComponent } from './reactions/reactions.component';
import { SettingsComponent } from './settings/settings.component';
import { TagsComponent } from './tags/tags.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent }, //stats
      { path: 'profiles', component: ProfilesComponent },
      { path: 'memes', component: MemesComponent },
      { path: 'tags', component: TagsComponent },
      { path: 'reactions', component: ReactionsComponent },
      { path: 'contacts', component: ContactsComponent },
      { path: 'settings', component: SettingsComponent },


      //user
      //meme
      //tag
      //reaction

    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}
