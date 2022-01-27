import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { BarmanService } from 'src/app/services/barman/barman-service.service';
import { CookService } from 'src/app/services/cook/cook-service.service';

@Component({
  selector: 'app-cook-table',
  templateUrl: './cook-table.component.html',
  styleUrls: ['./cook-table.component.css']
})
export class CookTableComponent implements OnInit {

  cooks: UserId[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];


  constructor(
    private router: Router,
    private cookService: CookService
  ) { }

  ngOnInit(){
    this.getAll();
  }

  getAll() {
    this.cookService.getAll().subscribe(
      res => {
        this.cooks = res;

        const datePipe = new DatePipe('en-US');
        this.cooks.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  addNew() {
    this.router.navigate([`add-cook`]);
  }

  deleteCook(id : number){
    this.cookService.delete(id).subscribe(
      res => {
        console.log(res);
      });

    this.cooks = this.cooks.filter(function( cook ) {
      return cook.id !== id;
    });
  }

}
