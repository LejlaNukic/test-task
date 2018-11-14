import { Component, OnInit, Input } from '@angular/core';
import { UserProfileModel } from '../../../models/user-profile.model';

@Component({
  selector: 'app-user-profile-details',
  templateUrl: './user-profile-details.component.html',
  styleUrls: ['./user-profile-details.component.css']
})
export class UserProfileDetailsComponent {

  @Input() userProfileDetails: UserProfileModel;

}
