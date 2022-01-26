import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { ManagerService } from 'src/app/services/manager/manager-service.service';

@Component({
  selector: 'app-change-salary-manager',
  templateUrl: './change-salary-manager.component.html',
  styleUrls: ['./change-salary-manager.component.css']
})
export class ChangeSalaryManagerComponent implements OnInit {

  //@Input() managerId : number;
  myParam: number;
  user : UserId;

  salary : number;
  
  constructor(
    private route: ActivatedRoute,
    private managerService : ManagerService
    ) { }

  ngOnInit(): void {
    
    this.route.params.subscribe((params: Params) => this.myParam = params['id']);

    //console.log(this.myParam);
    this.managerService.getOne(this.myParam).subscribe(
      res => {
        this.user = new UserId(res.id, res.username, res.password, res.firstName, res.lastName, res.dateOfBirth, res.salary);

        console.log(this.user);
      })
    }

}
