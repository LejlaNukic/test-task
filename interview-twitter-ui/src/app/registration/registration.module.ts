import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {SharedModule} from '../shared/shared.module';
import { RegistrationContainerComponent } from './registration-container/registration-container.component';
import { RegistrationComponent } from './registration/registration.component';
import { RegistrationService } from '../services/registration.service';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';


@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '', component: RegistrationContainerComponent, children: [
          {path: '', component: RegistrationComponent},
        ],
      },
    ]),
    CommonModule,
    FormsModule,
    SharedModule
  ],
  providers: [
    RegistrationService
  ],
  declarations: [RegistrationComponent, RegistrationContainerComponent]
})
export class RegistrationModule { }
