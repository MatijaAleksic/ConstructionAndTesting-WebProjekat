import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { ManagerService } from 'src/app/services/manager/manager-service.service';

@Component({
  selector: 'app-change-salary-manager',
  templateUrl: './change-salary-manager.component.html',
  styleUrls: ['./change-salary-manager.component.css']
})
export class ChangeSalaryManagerComponent implements OnInit {

  myParam: number;
  user : UserId;

  salary : number;

  //validateForm: FormGroup;
  
  constructor(
    private route: ActivatedRoute,
    private managerService : ManagerService,
    private router : Router,
    ) { }

  ngOnInit(): void {
    
    this.route.params.subscribe((params: Params) => this.myParam = params['id']);

    // this.validateForm = new FormGroup({
    //   'salary': new FormControl(null, [Validators.required, Validators.min(0), Validators.max(999999)]),
    // });
  
    this.managerService.getOne(this.myParam).subscribe(
      res => {
        this.user = new UserId(res.id, res.username, res.password, res.firstName, res.lastName, res.dateOfBirth, res.salary);
        //this.validateForm.value.salary = this.user.salary;
        this.salary = this.user.salary;

      })
  }

  changeSalary(){
    this.user.salary = this.salary;

    this.managerService.update(this.user).subscribe(
      {
        next: data => {
          if(data !== null) {
            console.log(data);
            this.router.navigate(['manager-table'])
          }
        }
      }
    );
  }

}
