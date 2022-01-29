import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { ProfileService } from '../services/profile/profile.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  username : string;
  password : string;
  firstName : string;
  lastName : string;
  dateOfBirth : string;
  salary : number;

  user_role : string;


  constructor(
    public router: Router,
    private authService: AuthentitacionService,
    private profileService : ProfileService
  ) { }

  ngOnInit(): void {

    this.user_role = this.authService.getUserRole();

    this.profileService.findOne(this.authService.getUserId()).subscribe( (data) => {
      if (data !== null) {
        this.username = data.username;
        this.password = data.password;
        this.lastName = data.lastName;
        this.firstName = data.firstName;

        const datePipe = new DatePipe('en-US');
        this.dateOfBirth = datePipe.transform(data.dateOfBirth, 'dd/MM/yyyy') || "";

        this.salary = data.salary;
      }
    });
  }

  alertuj(text : string){
    alert(text);
  }

}
