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
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';
import { UserService } from '../services/user/user-service.service';
import { OrderService } from '../services/order/order.service';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { OrderedItem } from '../model/ordered-item';
import { Order } from '../model/order';
import { Table } from '../model/table';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

/**
 * @title Adding and removing data when using an array-based datasource.
 */
@Component({
  selector: 'drink-menu.component',
  styleUrls: ['drink-starting-menu.component.css'],
  templateUrl: 'drink-starting-menu.component.html',
})
export class DrinkMenuComponent {
  displayedColumns: string[] = ['picture', 'name', 'price'];
  dataSource: Observable<Item[]>;
  subcategories: string[];


  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet, private orderedItemService : OrderedItemService, 
    private orderService : OrderService, private userService : UserService, private authenticationService : AuthentitacionService){
    
  }

  ngOnInit(){
    
    this.itemService.getDrinkItemsCategories().subscribe(x=>{
      this.subcategories = x;
      this.dataSource = this.itemService.getDrinkItemsByCategory(this.subcategories[0]);
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
    this.dataSource = this.itemService.getDrinkItemsByCategory(button)
    this.table.renderRows();
  }


  showShoppingCart(){
    this._bottomSheet.open(Cart);

  }


  finalizeOrder(){
    const orderedItems = this.itemService.getOrderedItems();
    const id = this.authenticationService.getUserId();
    const user = this.userService.getOne(id);
    let realOrderedItems : OrderedItem[] = []
    let priceOfTheOrder = 0
    for(let i = 0; i < orderedItems.length; i++){
      const temp = (new OrderedItem(orderedItems[i].price, orderedItems[i].number, "ordered", orderedItems[i], user, orderedItems[i].note))
      realOrderedItems.push(temp);
      this.orderedItemService.create(temp);
      console.log(temp);
      priceOfTheOrder += orderedItems[i].price;
    }
    let orderTable = new Table(1, 1, 1, 1, "free");

    orderTable.id = 1
    const currentOrder = new Order(priceOfTheOrder, user,  orderTable);
    //this.orderService.create(currentOrder);


  }
  

}

