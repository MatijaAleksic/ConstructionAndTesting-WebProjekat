import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from 'src/app/model/item.model';
import { DrinkService } from 'src/app/services/drink/drink-service.service';
import { FoodService } from 'src/app/services/food/food-service.service';
import { ItemService } from 'src/app/services/Items/item.service';


export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}



@Component({
  selector: 'app-new-recipe-table',
  templateUrl: './new-recipe-table.component.html',
  styleUrls: ['./new-recipe-table.component.css']
})
export class NewRecipeTableComponent implements OnInit {

  displayedColumns: string[] = ['picture', 'name', 'price', 'status', 'subcategory', 'description', 'priority', 'activate', "deactivate"];
  dataSource: Observable<Item[]>;
  subcategories: string[] = ["foods", "drinks"];
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  
  constructor(
    private router: Router,
    private itemService: ItemService,
    private foodService : FoodService,
    private drinkService : DrinkService
  ) { }

  ngOnInit(){
    this.itemService.getItemsNew().subscribe(
          res => {
            console.log(res);
          }
        )
    this.dataSource = this.itemService.getItemsNew();
  }

  activateStatus(element : Item)
  {
    element.itemStatus = "active"

    this.itemService.updateItem(element).subscribe(
      {
        next: data => {
          console.log(data);
          if(data !== null) {
            this.router.navigate(['new-recipe-table'])
          }
        }
      }
    );
  }

  deactivateStatus(element : Item)
  {
    element.itemStatus = "inactive"

    this.itemService.updateItem(element).subscribe(
      {
        next: data => {
          console.log(data);
          if(data !== null) {
            this.router.navigate(['new-recipe-table'])
          }
        }
      }
    );
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
      this.dataSource = this.foodService.getAllNew();
    }
    else{
      this.dataSource = this.drinkService.getAllNew();
    }  }

}
