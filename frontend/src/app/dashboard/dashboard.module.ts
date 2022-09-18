import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { ProfilesComponent } from './profiles/profiles.component';
import { MemesComponent } from './memes/memes.component';
import { TagsComponent } from './tags/tags.component';
import { SettingsComponent } from './settings/settings.component';
import { ReactionsComponent } from './reactions/reactions.component';
import { ContactsComponent } from './contacts/contacts.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { NgbdSortableHeader } from './profiles/sortable.directive';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ProfilesComponent,
    MemesComponent,
    TagsComponent,
    SettingsComponent,
    ReactionsComponent,
    ContactsComponent,
    NotificationsComponent,
    NgbdSortableHeader
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    NgbModule,
    FormsModule
  ]
})
export class DashboardModule { }
