import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../../services/registration.service';
@Component({
  moduleId: module.id,
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  model: any = {username: '', password: '', fullname: ''};
  error: null;
  loading = false;
  incorrectCredentialsError = false;

  constructor(private router: Router, private registrationService: RegistrationService) { }

  onSubmit(registrationForm: NgForm): void {
    if (registrationForm.valid) {
      this.register();
    }
  }

  register() {
    this.loading = true;
    this.registrationService.register(this.model)
        .subscribe(
          () => this.router.navigate(['/login']),
          error => {
            this.error = error;
          }
        );
  }

  isFormSubmittedWithInvalidUsername(registrationForm: NgForm): boolean {
    const usernameFormControl = registrationForm.form.controls['username'];
    return registrationForm.submitted && usernameFormControl && !usernameFormControl.valid;
  }

  isFormSubmittedWithInvalidPassword(registrationForm: NgForm): boolean {
    const passwordFormControl = registrationForm.form.controls['password'];
    return registrationForm.submitted && passwordFormControl && !passwordFormControl.valid;
  }

  isFormSubmittedWithInvalidFullname(registrationForm: NgForm): boolean {
    const fullnameFormControl = registrationForm.form.controls['fullname'];
    return registrationForm.submitted && fullnameFormControl && !fullnameFormControl.valid;
  }
 

}
