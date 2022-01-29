import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { WaiterService } from 'src/app/services/waiter/waiter-service.service';

@Component({
  selector: 'app-add-new-waiter',
  templateUrl: './add-new-waiter.component.html',
  styleUrls: ['./add-new-waiter.component.css']
})
export class AddNewWaiterComponent implements OnInit {

  addNewWaiterForm: FormGroup;
  newWaiter : User;

  constructor(
    public router: Router,
    public waiterService : WaiterService
  ) { }

  ngOnInit(): void {
    this.addNewWaiterForm = new FormGroup({
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
      this.addNewWaiterForm.value.username,  
      this.addNewWaiterForm.value.password,
      this.addNewWaiterForm.value.firstName,
      this.addNewWaiterForm.value.lastName,
      this.addNewWaiterForm.value.dateOfBirth,
      this.addNewWaiterForm.value.salary,
    )

    this.waiterService.create(this.newWaiter).subscribe(
      {
        next: data => {
            this.router.navigate(['waiter-table'])
          }
        }
    );
  }

}
