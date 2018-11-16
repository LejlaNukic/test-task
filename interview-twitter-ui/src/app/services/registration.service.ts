import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { UserModel } from "../models/user.model";
import { Observable } from 'rxjs';


const ENDPOINT_BASE = '/api/register';

@Injectable()
export class RegistrationService {

  constructor(private http: HttpClient) {
  }

  register(userContent: UserModel): Observable<any> {
    return this.http.post<UserModel>(ENDPOINT_BASE, userContent);
  }
}

