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
import { OrderService } from '../services/order/order.service';
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';
import { UserService } from '../services/user/user-service.service';
import { RestourantTableService } from '../services/restourantTables/restourant-tables.service';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { UserId } from '../model/user-id';
import { OrderedItem } from '../model/ordered-item';
import { OrderBack } from '../model/order';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
  number: number;
  remove: any;
  add: any;
}


@Component({
  selector: 'cart',
  templateUrl: 'cart.component.html',
  styleUrls: ['cart.component.css'],

})
export class Cart {
  constructor(private itemService : ItemService, private _bottomSheetRef: MatBottomSheetRef<Cart>,
    private _bottomSheet: MatBottomSheet, private orderedItemService : OrderedItemService, 
    private orderService : OrderService, private userService : UserService, private authenticationService : AuthentitacionService, 
    private restourantTableService : RestourantTableService, private _snackBar: MatSnackBar ) {}
  displayedColumns2: string[] = ['picture', 'name', 'price', "number", "remove", "add"];
  
  dataSource2: Item[];

  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  ngOnInit(){
    this.dataSource2 = this.itemService.getOrderedItems();
  }


  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }


  addItem(item : Item){
    this.itemService.addOrderedItem(item);
    this.dataSource2 = this.itemService.getOrderedItems();
    this.table.renderRows();
  }

  cancelItem(item : Item){
    this.itemService.removeOrderedItem(item);
    this.dataSource2 = this.itemService.getOrderedItems();
    this.table.renderRows();
  }

  restartView(){
    this.dataSource2 = this.itemService.getOrderedItems();
    this.table.renderRows();
    
  }





  finalizeOrder(){
    if(Object.keys(this.restourantTableService.getCurrentTable()).length === 0){
      alert("Select a table first")
      return
    }
    const orderedItems = this.itemService.getOrderedItems();
    const id = this.authenticationService.getUserId();
    let user : UserId;
    this.userService.getOne(id).subscribe(x => {
      user = x;
      let realOrderedItems : number[] = []
      let priceOfTheOrder = 0
      new Observable( qwe => {
        for(let i = 0; i < orderedItems.length; i++){
          const temp = (new OrderedItem(orderedItems[i].price * orderedItems[i].number, orderedItems[i].number, "ordered", orderedItems[i], user, orderedItems[i].note))
          this.orderedItemService.create(temp).subscribe(y => {
            realOrderedItems.push(y.id);
            console.log(y);
            priceOfTheOrder += orderedItems[i].price * orderedItems[i].number;

            qwe.next(i)
          });
        }
      }).subscribe(z =>{
        console.log(z)
        if(realOrderedItems.length === orderedItems.length){

          const currentOrder = new OrderBack(priceOfTheOrder, user.id, this.restourantTableService.getCurrentTable().id, realOrderedItems, 0);
          console.log("order")
          console.log(currentOrder)
          this.orderService.create(currentOrder).subscribe();
          this.itemService.removeAllOrderedItems();
          this._snackBar.open("Successfully ordered for table ", this.restourantTableService.getCurrentTable().id + "", {duration: 5000});
          this.restartView();

        }
      })
      
    });
    


  }

  checkRole(role : string){
    if(localStorage.getItem('autorities') != null){
      return JSON.parse(localStorage.getItem('autorities') || '{}').some((e: { name: string; }) => e.name === role);
    }
    else{
      return false;
    }

  }

}