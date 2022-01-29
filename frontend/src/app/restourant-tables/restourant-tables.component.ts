import { DataSource } from '@angular/cdk/collections';
import {Component, ViewChild, ViewContainerRef} from '@angular/core';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import { Observable, ReplaySubject } from 'rxjs';
import { Item } from '../model/item.model';
import { ItemService } from '../services/Items/item.service';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import { MatSort } from '@angular/material/sort';
import {MatSnackBar} from '@angular/material/snack-bar';
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
import { RendererFactory2, Renderer2 } from '@angular/core';
import { CdkDragEnd } from '@angular/cdk/drag-drop';


export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

/**
 * @title Adding and removing data when using an array-based datasource.
 */
@Component({
  selector: 'restourant-tables.component',
  styleUrls: ['restourant-tables.component.css'],
  templateUrl: 'restourant-tables.component.html',
})
export class RestourantTablesComponent {
  restourantTables : Table[];
  numberOfFloors : number;
  activeFloor : number;
  floorRange: number[] = [];


  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet, private orderedItemService : OrderedItemService, 
    private orderService : OrderService, private userService : UserService, 
    private authenticationService : AuthentitacionService, private restourantTableService : RestourantTableService, public router : Router){
  }

  ngOnInit(){
    
    this.init();

  }

  init(){
    this.restourantTableService.getNumberOfFloors().subscribe(x =>{

      this.numberOfFloors = x;
      this.floorRange = [...Array(this.numberOfFloors+1).keys()];
    });
    this.activeFloor = this.restourantTableService.getCurrentTable()?.floor;
    this.restourantTableService.findTablesByFloor(this.activeFloor).subscribe(x => {
      this.makeTableUI(x);
    })
  }

  refresh(){
    this.restourantTableService.findTablesByFloor(this.activeFloor).subscribe(x => {
      this.makeTableUI(x);
    })
  }

  makeTableUI(x : Table[]){
    this.restourantTables = x;
  }

  addData() {
    const newTable = new Table(this.activeFloor, "free");
    this.restourantTableService.create(newTable).subscribe(x =>{
      this.refresh();

    });
  }

  removeData() {
    this.restourantTableService.delete(this.restourantTableService.getCurrentTable().id).subscribe();
  }


  subSelected(button: number) {
    this.restourantTableService.findTablesByFloor(button).subscribe(x =>{
      this.makeTableUI(x);
    });
    this.activeFloor = button;
  }


  showShoppingCart(){
    this._bottomSheet.open(Cart);

  }


  drop($event: CdkDragEnd, table : Table){
    console.log("DROP");
    console.log(table);
    console.log($event.source.getFreeDragPosition())
    table.position = $event.source.getFreeDragPosition();
    this.restourantTableService.update(table);
    this.restourantTableService.setCurrentTable(table);
  }


  clickEvent(table : Table){

  }

}

