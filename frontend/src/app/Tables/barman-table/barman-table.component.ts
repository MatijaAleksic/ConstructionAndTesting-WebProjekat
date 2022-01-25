
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { BarmanService } from 'src/app/services/barman/barman-service.service';

@Component({
  selector: 'app-barman-table',
  templateUrl: './barman-table.component.html',
  styleUrls: ['./barman-table.component.css']
})
export class BarmanTableComponent implements OnInit {

  barmans: User[] = [];
  //displayedColumns: string[] = ["id", "name"];

  constructor(
    private router: Router,
    private barmanService: BarmanService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.barmanService.getAll().subscribe(
      res => {
        this.barmans = res;
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  add() {
    alert("ADD NEW! TODO")
    //this.router.navigate([`category`]);
  }

}
