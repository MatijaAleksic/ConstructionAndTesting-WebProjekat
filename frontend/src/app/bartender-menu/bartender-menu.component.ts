import { DataSource } from '@angular/cdk/collections';
import { Component, ViewChild } from '@angular/core';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Observable, ReplaySubject } from 'rxjs';
import { Item } from '../model/item.model';
import { ItemService } from '../services/Items/item.service';
import { MatBottomSheet, MatBottomSheetRef } from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cart } from '../cart/cart.component';
import { UserService } from '../services/user/user-service.service';
import { OrderService } from '../services/order/order.service';
import { AuthentitacionService } from '../services/autentication/authentitacion.service';
import { OrderedItem } from '../model/ordered-item';
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';
import { Table } from '../model/table';
import { Order, OrderBack } from '../model/order';
import { UserId } from '../model/user-id';
import { RestourantTableService } from '../services/restourantTables/restourant-tables.service';
import { Router } from '@angular/router';
import { OrderedItemSheetComponent } from '../ordered-item-sheet/ordered-item-sheet.component';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

/**
 * @title Adding and removing data when using an array-based datasource.
 */
@Component({
  selector: 'bartender-menu.component',
  styleUrls: ['bartender-menu.component.css'],
  templateUrl: 'bartender-menu.component.html',
})
export class BartenderMenuComponent {
  displayedColumns: string[] = ['picture', 'name', 'price', 'number', 'state'];
  dataSource: OrderedItem[];
  restourantTables: Table[];
  activeTable: Table;

  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet, private orderedItemService: OrderedItemService,
    private orderService: OrderService, private userService: UserService,
    private authenticationService: AuthentitacionService, private restourantTableService: RestourantTableService, public router: Router,
    private _snackBar: MatSnackBar) {

  }

  ngOnInit() {

    this.init();

  }

  init() {
    this.restourantTableService.getAll().subscribe(x => {
      this.restourantTables = x;
      this.activeTable = this.restourantTableService.getCurrentTable();
      if (this.activeTable == null) {
        this.activeTable = this.restourantTables[0];
        this.restourantTableService.setCurrentTable(this.activeTable);
      }

      this.orderService.getOrderByTable(this.activeTable.id).subscribe(y => {
        if(y === null){
          this.dataSource = [];
  
        } else {
          this.dataSource = y.food;
        }
        this.restourantTableService.setCurrentTable(this.activeTable);
        this.table.renderRows();
        console.log(this.dataSource);
      });
    });
  }

  itemClicked(item: OrderedItem) {
    console.log(item);
    this.orderedItemService.setCurrentOrderedItem(item);
    this._bottomSheet.open(OrderedItemSheetComponent).afterDismissed().subscribe(x => {
      this.orderedItemService.update(this.orderedItemService.getCurrentOrderedItem());
      this.init();
    });

  }

  addData() {
    this.table.renderRows();
  }

  removeData() {
    this.table.renderRows();
  }


  subSelected(button: Table) {
    this.orderService.getOrderByTable(button.id).subscribe(y => {
      if(y === null){
        this.dataSource = [];

      } else {
        this.dataSource = y.food;
      }
      this.table.renderRows();
      this.restourantTableService.setCurrentTable(button);
      this.activeTable = button;
      console.log(this.dataSource);
    });
  }


  showShoppingCart() {
    this._bottomSheet.open(Cart);

  }

  finishOrder(){
    this.orderService.getOrderByTable(this.restourantTableService.getCurrentTable().id).subscribe(x =>{
      this.orderService.finishOrder(x.id).subscribe(y =>{
        this.init();
        this._snackBar.open("Finished order", "", {duration: 500});
      });
    })
    
  }


}

