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
  constructor(private itemService : ItemService, private _bottomSheetRef: MatBottomSheetRef<Cart>) {}
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
}