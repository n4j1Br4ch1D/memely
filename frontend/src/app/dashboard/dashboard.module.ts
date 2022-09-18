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
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { faSquarePlus as fasSquarePlus } from '@fortawesome/free-solid-svg-icons';
import { faEye as farEye } from '@fortawesome/free-regular-svg-icons';
import { faPenToSquare as farPenToSquare } from '@fortawesome/free-regular-svg-icons';
import { faTrashAlt as farTrashAlt } from '@fortawesome/free-regular-svg-icons';
import { faSpinner as fasSpinner } from '@fortawesome/free-solid-svg-icons';
import { faSort as fasSort } from '@fortawesome/free-solid-svg-icons';
import { faMagnifyingGlass as fasMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';


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
    FormsModule,
    FontAwesomeModule
  ]
})
export class DashboardModule { 
    constructor(library: FaIconLibrary) {
    library.addIcons(fasSquarePlus, farEye, farPenToSquare,farTrashAlt, fasSpinner, fasSort, fasMagnifyingGlass
      );

  }
}
