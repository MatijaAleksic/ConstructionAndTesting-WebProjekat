import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { CookService } from 'src/app/services/cook/cook-service.service';
import { MainCookService } from 'src/app/services/main-cook/main-cook-service.service';

@Component({
  selector: 'app-maincook-table',
  templateUrl: './maincook-table.component.html',
  styleUrls: ['./maincook-table.component.css']
})
export class MaincookTableComponent implements OnInit {

  mainCooks: UserId[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];

  
  constructor(
    private router: Router,
    private mainCookService: MainCookService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.mainCookService.getAll().subscribe(
      res => {
        this.mainCooks = res;

        const datePipe = new DatePipe('en-US');
        this.mainCooks.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  addNew() {
    this.router.navigate([`add-main-cook`]);
  }

  deleteMainCook(id : number){
    this.mainCookService.delete(id).subscribe(
      res => {
        console.log(res);
      });

    this.mainCooks = this.mainCooks.filter(function( cook ) {
      return cook.id !== id;
    });
  }

}
