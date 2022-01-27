import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from 'src/app/model/item.model';
import { DrinkService } from 'src/app/services/drink/drink-service.service';
import { PeriodicElement } from 'src/app/starting-menu/starting-menu.component';

@Component({
  selector: 'app-barman-recipe-table',
  templateUrl: './barman-recipe-table.component.html',
  styleUrls: ['./barman-recipe-table.component.css']
})
export class BarmanRecipeTableComponent implements OnInit {

  displayedColumns: string[] = ['picture', 'name', 'price', 'status', 'subcategory', 'description', 'priority', 'edit'];
  dataSource: Observable<Item[]>;
  subcategories: string[] = ["foods", "drinks"];
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  constructor(
    private router: Router,
    private drinkService : DrinkService,
  ) { }


  ngOnInit(): void {
    this.dataSource = this.drinkService.getAllNew();
  }

  newRecipe(){
    alert("New recipe TODO")
  }

  editData(element : Item){
    alert("Edit data TODO")
  }

  itemClicked(item: Item){
    console.log(item)
  }

}
