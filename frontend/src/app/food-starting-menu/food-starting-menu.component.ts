import { DataSource } from '@angular/cdk/collections';
import {Component, ViewChild} from '@angular/core';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import { Observable, ReplaySubject } from 'rxjs';
import { Item } from '../model/item.model';
import { ItemService } from '../services/Items/item.service';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import { MatSort } from '@angular/material/sort';
import {MatSnackBar} from '@angular/material/snack-bar';
import { BottomSheetOverviewExampleSheet } from '../item-sheet/item-sheet.component';
import { Cart } from '../cart/cart.component';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

/**
 * @title Adding and removing data when using an array-based datasource.
 */
@Component({
  selector: 'food-menu.component',
  styleUrls: ['food-starting-menu.component.css'],
  templateUrl: 'food-starting-menu.component.html',
})
export class FoodMenuComponent {
  displayedColumns: string[] = ['picture', 'name', 'price'];
  dataSource: Observable<Item[]>;
  subcategories: string[];


  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet){
    
  }

  ngOnInit(){
    
    this.itemService.getFoodItemsCategories().subscribe(x=>{
      this.subcategories = x;
      this.dataSource = this.itemService.getFoodItemsByCategory(this.subcategories[0]);
    });

  }

  itemClicked(item: Item){
    console.log(item);
    this.itemService.setItem(item);
    this._bottomSheet.open(BottomSheetOverviewExampleSheet);

  }

  addData() {
    this.table.renderRows();
  }

  removeData() {
    this.table.renderRows();
  }


  subSelected(button: string) {
    this.dataSource = this.itemService.getFoodItemsByCategory(button)
    this.table.renderRows();
  }


  showShoppingCart(){
    this._bottomSheet.open(Cart);

  }

  

}

