import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { BarmanService } from 'src/app/services/barman/barman-service.service';

@Component({
  selector: 'app-add-new-barman',
  templateUrl: './add-new-barman.component.html',
  styleUrls: ['./add-new-barman.component.css']
})
export class AddNewBarmanComponent implements OnInit {

  addNewBarmanForm: FormGroup;
  newBarman : User;
  
  constructor(
    public router: Router,
    public barmanService : BarmanService
  ) { }

  ngOnInit(): void {
    this.addNewBarmanForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'dateOfBirth': new FormControl(null, [Validators.required]),
      'salary': new FormControl(null, [Validators.required, Validators.minLength(8)])

    });
  }

  addNew(){
    this.newBarman = new User(
      this.addNewBarmanForm.value.username,  
      this.addNewBarmanForm.value.password,
      this.addNewBarmanForm.value.firstName,
      this.addNewBarmanForm.value.lastName,
      this.addNewBarmanForm.value.dateOfBirth,
      this.addNewBarmanForm.value.salary,
    )

    this.barmanService.create(this.newBarman).subscribe(
      {
        next: data => {
            this.router.navigate(['barman-table'])
          }
        }
    );
  }



}
