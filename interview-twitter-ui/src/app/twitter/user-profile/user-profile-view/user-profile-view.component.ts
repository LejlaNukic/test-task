import { Component, OnInit } from '@angular/core';
import { UserProfileModel } from '../../../models/user-profile.model';
import { Observable } from 'rxjs/Observable';
import { UserProfileService } from '../../../services/user-profile/user-profile.service';
import {AuthService} from "../../../services/auth.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-user-profile-view',
  templateUrl: './user-profile-view.component.html',
  styleUrls: ['./user-profile-view.component.css']
})
export class UserProfileViewComponent implements OnInit {

  $userProfileDetails: Observable<UserProfileModel>;
  constructor(private userProfileService: UserProfileService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {  
      this.$userProfileDetails = this.userProfileService.fetchForUser();
      console.log(this.$userProfileDetails);
  }

}
