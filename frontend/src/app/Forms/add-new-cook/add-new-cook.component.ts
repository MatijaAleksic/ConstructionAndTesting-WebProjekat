import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { CookService } from 'src/app/services/cook/cook-service.service';

@Component({
  selector: 'app-add-new-cook',
  templateUrl: './add-new-cook.component.html',
  styleUrls: ['./add-new-cook.component.css']
})
export class AddNewCookComponent implements OnInit {

  addNewCookForm: FormGroup;
  newCook : User;

  constructor(
    public router: Router,
    public cookService : CookService
  ) { }

  ngOnInit(): void {
    this.addNewCookForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'dateOfBirth': new FormControl(null, [Validators.required]),
      'salary': new FormControl(null, [Validators.required, Validators.minLength(8)])

    });
  }

  addNew(){
    this.newCook = new User(
      this.addNewCookForm.value.username,  
      this.addNewCookForm.value.password,
      this.addNewCookForm.value.firstName,
      this.addNewCookForm.value.lastName,
      this.addNewCookForm.value.dateOfBirth,
      this.addNewCookForm.value.salary,
    )

    console.log(this.newCook);

    this.cookService.create(this.newCook).subscribe(
      {
        next: data => {
            this.router.navigate(['cook-table'])
          }
        }
    );
  }

}
