import { NgModule } from '@angular/core';
import {RouterModule} from "@angular/router";
import { CommonModule } from '@angular/common';
import { UserProfileContainerComponent } from './user-profile-container/user-profile-container.component';
import { UserProfileViewComponent } from './user-profile-view/user-profile-view.component';
import { UserProfileDetailsComponent } from './user-profile-details/user-profile-details.component';
import { UserProfileService } from '../../services/user-profile/user-profile.service';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '', component: UserProfileContainerComponent, children: [
          {path: '', component: UserProfileViewComponent},
        ],
      },
    ]),
    CommonModule
  ],
  declarations: [UserProfileContainerComponent, UserProfileViewComponent, UserProfileDetailsComponent]
})
export class UserProfileModule { }
