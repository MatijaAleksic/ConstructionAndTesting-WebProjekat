import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PasswordChanger } from 'src/app/model/password-changer';
import { AuthentitacionService } from 'src/app/services/autentication/authentitacion.service';
import { ProfileService } from 'src/app/services/profile/profile.service';

@Component({
  selector: 'app-change-password-form',
  templateUrl: './change-password-form.component.html',
  styleUrls: ['./change-password-form.component.css']
})
export class ChangePasswordFormComponent implements OnInit {

  changePassowrdForm : FormGroup;
  passwordChanger : PasswordChanger;

  constructor(
    public router: Router,
    private profileService : ProfileService
  ) { }

  ngOnInit(): void {
    this.changePassowrdForm = new FormGroup({
      'oldPassword': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'newPassword': new FormControl(null, [Validators.required, Validators.minLength(5)])
    });
  }

  changePassword(){
    this.passwordChanger = new PasswordChanger(this.changePassowrdForm.value.oldPassword, this.changePassowrdForm.value.newPassword);
    this.profileService.chagePassword(this.passwordChanger).subscribe(
      (data) => { 
        console.log(data);
        if(data.result === "success")
        {
          alert("Sucess!")
          this.router.navigate(['profile'])
        }
        else{
          alert("Wrong password!")
        }
          
        }

    );
  }

}
