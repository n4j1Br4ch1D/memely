import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Role } from '../_enums/role';
import { AuthUserGuard } from '../_guards/auth-user.guard';
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

const routes: Routes = [
  {
    path: '',
    // component: ProfileComponent,
    children: [
      { path: '', component: MyMemesComponent },
      { path: 'memes', component: MyMemesComponent },
      {
        path: 'favorites',
        component: MyFavoritesComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'reactions',
        component: MyReactionsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: true },
      },
      {
        path: 'comments',
        component: MyCommentsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: true },
      },
      {
        path: 'mentions',
        component: MyMentionsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'followings',
        component: MyFollowingsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: true },
      },
      {
        path: 'followers',
        component: MyFollowersComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: true },
      },
      {
        path: 'messages',
        component: MyMessagesComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'contacts',
        component: MyContactsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'reports',
        component: MyReportsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'notifications',
        component: MyNotificationsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
      {
        path: 'settings',
        component: MySettingsComponent,
        runGuardsAndResolvers: 'always',
        canActivate: [AuthUserGuard],
        data: { role: Role.USER, allowed: false },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfileRoutingModule {}
