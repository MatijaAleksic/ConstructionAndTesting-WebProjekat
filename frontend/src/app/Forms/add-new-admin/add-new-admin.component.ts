import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AdminService } from 'src/app/services/admin/admin-service.service';

@Component({
  selector: 'app-add-new-admin',
  templateUrl: './add-new-admin.component.html',
  styleUrls: ['./add-new-admin.component.css']
})
export class AddNewAdminComponent implements OnInit {

  addNewAdminForm: FormGroup;
  newAdmin : User;
  
  constructor(
    public router: Router,
    public adminService : AdminService
  ) { }

  ngOnInit(): void {
    this.addNewAdminForm = new FormGroup({
      'firstName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'lastName': new FormControl(null, [Validators.required, Validators.minLength(5)]),
      'username': new FormControl(null, [Validators.required, Validators.email]),
      'password': new FormControl(null, [Validators.required, Validators.minLength(8)]),
      'dateOfBirth': new FormControl(null, [Validators.required]),
      'salary': new FormControl(null, [Validators.required, Validators.minLength(8)])

    });
  }

  addNew(){
    this.newAdmin = new User(
      this.addNewAdminForm.value.username,  
      this.addNewAdminForm.value.password,
      this.addNewAdminForm.value.firstName,
      this.addNewAdminForm.value.lastName,
      this.addNewAdminForm.value.dateOfBirth,
      this.addNewAdminForm.value.salary,
    )

    this.adminService.create(this.newAdmin).subscribe(
      {
        next: data => {
            this.router.navigate(['admin-table'])
          }
        }
    );
  }

}
