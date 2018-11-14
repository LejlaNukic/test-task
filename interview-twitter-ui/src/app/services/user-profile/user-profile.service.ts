import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { UserProfileModel } from '../../models/user-profile.model';

const ENDPOINT_BASE = '/api/userprofile';

@Injectable()
export class UserProfileService {

  constructor(private http: HttpClient) { }

  fetchForUser(): Observable<UserProfileModel> {
    return this.http.get<UserProfileModel>(ENDPOINT_BASE);
  }


}
