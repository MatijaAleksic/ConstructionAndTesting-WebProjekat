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
import { UserService } from '../services/user/user-service.service';
import { OrderService } from '../services/order/order.service';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { OrderedItem } from '../model/ordered-item';
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';
import { Table } from '../model/table';
import { Order, OrderBack } from '../model/order';
import { UserId } from '../model/user-id';


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


  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet, private orderedItemService : OrderedItemService, 
    private orderService : OrderService, private userService : UserService, private authenticationService : AuthentitacionService){
    
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

  finalizeOrder(){
    const orderedItems = this.itemService.getOrderedItems();
    const id = this.authenticationService.getUserId();
    let user : UserId;
    this.userService.getOne(id).subscribe(x => {
      user = x;
      let realOrderedItems : number[] = []
      let priceOfTheOrder = 0
      new Observable( qwe => {
        for(let i = 0; i < orderedItems.length; i++){
          const temp = (new OrderedItem(orderedItems[i].price, orderedItems[i].number, "ordered", orderedItems[i], user, orderedItems[i].note))
          this.orderedItemService.create(temp).subscribe(y => {
            realOrderedItems.push(y.id);
            console.log(y);
            priceOfTheOrder += orderedItems[i].price;
            qwe.next(i)
          });
        }
      }).subscribe(z =>{
        console.log(z)
        if(realOrderedItems.length === orderedItems.length){
          const currentOrder = new OrderBack(priceOfTheOrder, user.id, 1, realOrderedItems);
          console.log("order")
          console.log(currentOrder)
          this.orderService.create(currentOrder).subscribe();
        }
      })
      
    });
    


  }

}

