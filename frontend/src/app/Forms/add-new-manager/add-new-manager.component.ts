import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { BarmanService } from 'src/app/services/barman/barman-service.service';
import { ManagerService } from 'src/app/services/manager/manager-service.service';

@Component({
  selector: 'app-add-new-manager',
  templateUrl: './add-new-manager.component.html',
  styleUrls: ['./add-new-manager.component.css']
})
export class AddNewManagerComponent implements OnInit {

  addNewManagerForm: FormGroup;
  newWaiter : User;

  constructor(
    public router: Router,
    public managerService : ManagerService
  ) { }

  ngOnInit(): void {
    this.addNewManagerForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'dateOfBirth': new FormControl(null, [Validators.required]),
      'salary': new FormControl(null, [Validators.required, Validators.minLength(8)])

    });
  }

  addNew(){
    this.newWaiter = new User(
      this.addNewManagerForm.value.username,  
      this.addNewManagerForm.value.password,
      this.addNewManagerForm.value.firstName,
      this.addNewManagerForm.value.lastName,
      this.addNewManagerForm.value.dateOfBirth,
      this.addNewManagerForm.value.salary,
    )

    this.managerService.create(this.newWaiter).subscribe(
      {
        next: data => {
            this.router.navigate(['manager-table'])
          }
        }
    );
  }

}
