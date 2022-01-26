import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { WaiterService } from 'src/app/services/waiter/waiter-service.service';

@Component({
  selector: 'app-waiter-table',
  templateUrl: './waiter-table.component.html',
  styleUrls: ['./waiter-table.component.css']
})
export class WaiterTableComponent implements OnInit {

  waiters: UserId[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];


  constructor(
    private router: Router,
    private waiterService: WaiterService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.waiterService.getAll().subscribe(
      res => {
        this.waiters = res;

        const datePipe = new DatePipe('en-US');
        this.waiters.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  addNew() {
    this.router.navigate([`add-waiter`]);
  }

  deleteWaiter(id : number){
    this.waiterService.delete(id).subscribe(
      res => {
        console.log(res);
      });

    this.waiters = this.waiters.filter(function( waiter ) {
      return waiter.id !== id;
  });

  }

}
