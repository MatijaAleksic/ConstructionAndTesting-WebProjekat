import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { MainCookService } from 'src/app/services/main-cook/main-cook-service.service';

@Component({
  selector: 'app-add-new-maincook',
  templateUrl: './add-new-maincook.component.html',
  styleUrls: ['./add-new-maincook.component.css']
})
export class AddNewMaincookComponent implements OnInit {

  addNewMainCookForm: FormGroup;
  newMainCook : User;

  constructor(
    public router: Router,
    public mainCookService : MainCookService
  ) { }

  ngOnInit(): void {
    this.addNewMainCookForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'dateOfBirth': new FormControl(null, [Validators.required]),
      'salary': new FormControl(null, [Validators.required, Validators.minLength(8)])

    });
  }

  addNew(){
    this.newMainCook = new User(
      this.addNewMainCookForm.value.username,  
      this.addNewMainCookForm.value.password,
      this.addNewMainCookForm.value.firstName,
      this.addNewMainCookForm.value.lastName,
      this.addNewMainCookForm.value.dateOfBirth,
      this.addNewMainCookForm.value.salary,
    )

    this.mainCookService.create(this.newMainCook).subscribe(
      {
        next: data => {
            this.router.navigate(['main-cook-table'])
          }
        }
    );
  }

}
