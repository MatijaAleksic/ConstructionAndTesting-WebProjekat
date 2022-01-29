import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { ManagerService } from 'src/app/services/manager/manager-service.service';
import { UserService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-change-salary-user',
  templateUrl: './change-salary-user.component.html',
  styleUrls: ['./change-salary-user.component.css']
})
export class ChangeSalaryUserComponent implements OnInit {

  myParam: number;
  user : UserId;

  salary : number;
  
  constructor(
    private route: ActivatedRoute,
    private userService : UserService,
    private router : Router,
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe((params: Params) => this.myParam = params['id']);
  
    this.userService.getOne(this.myParam).subscribe(
      res => {
        this.user = new UserId(res.id, res.username, res.password, res.firstName, res.lastName, res.dateOfBirth, res.salary);
        this.salary = this.user.salary;

      })
  }

  changeSalary(){
    this.user.salary = this.salary;

    this.userService.update(this.user).subscribe(
      {
        next: data => {
          if(data !== null) {
            console.log(data);
            this.router.navigate(['staff-table'])
          }
        }
      }
    );
  }

}
