import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Item } from 'src/app/model/item.model';
import { FoodService } from 'src/app/services/food/food-service.service';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}


@Component({
  selector: 'app-maincook-recipe-table',
  templateUrl: './maincook-recipe-table.component.html',
  styleUrls: ['./maincook-recipe-table.component.css']
})
export class MaincookRecipeTableComponent implements OnInit {

  displayedColumns: string[] = ['picture', 'name', 'price', 'status', 'subcategory', 'description', 'priority', 'edit'];
  dataSource: Observable<Item[]>;
  subcategories: string[] = ["foods", "drinks"];
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  constructor(
    private router: Router,
    private foodService : FoodService,
  ) { }


  ngOnInit(): void {
    this.dataSource = this.foodService.getAllNew();
  }

  newRecipe(){
    this.router.navigate([`add-food`]);
  }

  editData(element : Item){
    this.router.navigate([`edit-item-info`, {id : element.id}]);
  }

  itemClicked(item: Item){
    console.log(item)
  }

}
