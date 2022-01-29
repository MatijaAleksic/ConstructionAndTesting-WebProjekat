import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { AdminService } from 'src/app/services/admin/admin-service.service';

@Component({
  selector: 'app-admin-table',
  templateUrl: './admin-table.component.html',
  styleUrls: ['./admin-table.component.css']
})
export class AdminTableComponent implements OnInit {

  admins: UserId[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];


  constructor(
    private router: Router,
    private adminService: AdminService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.adminService.getAll().subscribe(
      res => {
        this.admins = res;

        const datePipe = new DatePipe('en-US');
        this.admins.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  addNew() {
    this.router.navigate([`add-admin`]);
  }

  deleteAdmin(id : number){
    this.adminService.delete(id).subscribe(
      res => {
        console.log(res);
      });

    this.admins = this.admins.filter(function( admin ) {
      return admin.id !== id;
  });

  }

}
