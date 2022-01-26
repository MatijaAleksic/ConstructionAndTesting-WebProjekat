import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { ManagerService } from 'src/app/services/manager/manager-service.service';

@Component({
  selector: 'app-manager-table',
  templateUrl: './manager-table.component.html',
  styleUrls: ['./manager-table.component.css']
})
export class ManagerTableComponent implements OnInit {

  managers: UserId[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];


  constructor(
    private router: Router,
    private managerService: ManagerService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.managerService.getAll().subscribe(
      res => {
        this.managers = res;

        const datePipe = new DatePipe('en-US');
        this.managers.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
      },
      () => {
        alert("SHIT!")
      }
    )
  }

  addNew() {
    this.router.navigate([`add-manager`]);
  }

  deleteManager(id : number){
    this.managerService.delete(id).subscribe(
      res => {
        console.log(res);
      });

    this.managers = this.managers.filter(function( manager ) {
      return manager.id !== id;
  });

  }

}
