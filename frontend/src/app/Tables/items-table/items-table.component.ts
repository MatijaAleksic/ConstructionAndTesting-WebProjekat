import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Observable } from 'rxjs';
import { Item } from 'src/app/model/item.model';
import { ItemService } from 'src/app/services/Items/item.service';
import { PeriodicElement } from 'src/app/starting-menu/starting-menu.component';

import { FoodService } from 'src/app/services/food/food-service.service';
import { DrinkService } from 'src/app/services/drink/drink-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-items-table',
  templateUrl: './items-table.component.html',
  styleUrls: ['./items-table.component.css']
})
export class ItemsTableComponent implements OnInit {

  displayedColumns: string[] = ['picture', 'name', 'price', 'status', 'subcategory', 'description', 'priority', 'editPrice'];
  dataSource: Observable<Item[]>;
  subcategories: string[] = ["foods", "drinks"];

  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  constructor(
    private router: Router,
    private itemService: ItemService,
    private foodService : FoodService,
    private drinkService : DrinkService) { }

  ngOnInit(){
    this.itemService.getItems().subscribe(
          res => {
            console.log(res);
          }
        )
    this.dataSource = this.itemService.getItems();
  }

  // getAllFoods() {
  //   this.foodService.getAll().subscribe(
  //     res => {
  //       this.foods = res;
  //       console.log(res);
  //       this.getAllDrinks();
  //     }
  //   )
  // }

  // getAllDrinks(){
  //   this.drinkService.getAll().subscribe(
  //     res => {
  //       this.drinks = res;
  //       console.log(res);
  //   });
  // }

  editPrice(id : number)
  {
    this.router.navigate([`edit-item-price`, {id : id}]);
  }



  itemClicked(item: Item){
    console.log(item)
  }

  addData() {
    console.log(this.dataSource)
    this.table.renderRows();
    console.log(this.dataSource)
  }

  removeData() {
    this.table.renderRows();
  }


  subSelected(button: string) {
    if(button === "foods"){
      this.dataSource = this.foodService.getAll();
    }
    else{
      this.dataSource = this.drinkService.getAll();
    }  }

}
