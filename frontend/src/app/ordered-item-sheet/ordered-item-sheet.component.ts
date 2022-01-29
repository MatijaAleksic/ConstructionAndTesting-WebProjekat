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
import { OrderedItem } from '../model/ordered-item';
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';



@Component({
  selector: 'ordered-item-sheet',
  templateUrl: 'ordered-item-sheet.component.html',
  styleUrls: ['ordered-item-sheet.component.css'],

})
export class OrderedItemSheetComponent {
  constructor(private itemService : ItemService, private _bottomSheetRef: MatBottomSheetRef<OrderedItemSheetComponent>, private _snackBar: MatSnackBar,
    private orderedItemService : OrderedItemService) {}
  
  orderedItem: OrderedItem;
  title: string;
  description: string;
  subcategory: string;
  picture: string;

  ngOnInit(){
    this.init();
  }


  init(){
    const orderedItem = this.orderedItemService.getCurrentOrderedItem();
    this.orderedItem = orderedItem
    this.title = orderedItem.item.name;
    this.description = orderedItem.item.description;
    this.subcategory = orderedItem.item.subcategory;
    this.picture = orderedItem.item.picture;
  }


  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
    
  }

  addItem(){
    this.orderedItem.number++;
    this.orderedItemService.update(this.orderedItem);
    this._snackBar.open(this.orderedItem.item.name + " added " + this.orderedItem.number, "", {duration: 500});
    this.init();
  }

  cancelItem(){
    
    this.orderedItemService.delete(this.orderedItem.id).subscribe(x =>{
      this._snackBar.open(this.orderedItem.item.name, "removed", {duration: 500});
      this._bottomSheetRef.dismiss();
      this.init();
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