import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserLogin } from '../../../app//model/user-login' //'../model/user-login';
import { AuthentitacionService } from '../../services/autentication/authentitacion.service';//'../../../app//model/service/auth-service/authentication.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  access_token = null; 
  loginForm: FormGroup;
  loggedUser: UserLogin;

  constructor(
    public router: Router,
    private authService: AuthentitacionService
  ) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)])
    });
  }

  login() {
      this.loggedUser = new UserLogin(
        this.loginForm.value.username,  
        this.loginForm.value.password
      )

      this.authService.login(this.loggedUser).subscribe(
        {
          next: data => {
            localStorage.setItem('LoggedInUser', JSON.stringify(data.accessToken));
            if(data !== null) {
              this.router.navigate(['profile'])
            }
          }
        }
      );
  }

}
