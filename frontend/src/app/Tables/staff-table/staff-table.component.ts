import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuth } from 'src/app/model/user-auth';
import { UserId } from 'src/app/model/user-id';
import { StaffService } from 'src/app/services/staff/staff-service.service';

@Component({
  selector: 'app-staff-table',
  templateUrl: './staff-table.component.html',
  styleUrls: ['./staff-table.component.css']
})
export class StaffTableComponent implements OnInit {

  staffs: UserAuth[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth","salary","role",  "editSalary"];


  constructor(
    private router: Router,
    private staffService: StaffService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.staffService.getAllStaff().subscribe(
      res => {
        this.staffs = res;
        this.concatenateWaiters();
      }
    )
  }

  concatenateWaiters(){
    this.staffService.getAllWaiters().subscribe(
      res => {
        this.staffs = this.staffs.concat(res);

        const datePipe = new DatePipe('en-US');
        this.staffs.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      }); 
    });
  }

  editSalary(id : number){
    this.router.navigate([`edit-salary-user`, {id : id}]);
  }

}
