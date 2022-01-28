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




@Component({
  selector: 'item-sheet',
  templateUrl: 'item-sheet.component.html',
  styleUrls: ['item-sheet.component.css'],

})
export class BottomSheetOverviewExampleSheet {
  constructor(private itemService : ItemService, private _bottomSheetRef: MatBottomSheetRef<BottomSheetOverviewExampleSheet>, private _snackBar: MatSnackBar ) {}
  
  item: Item;
  title: string;
  description: string;
  subcategory: string;
  picture: string;

  ngOnInit(){
    const item = this.itemService.getItem();
    this.title = item.name;
    this.description = item.description;
    this.subcategory = item.subcategory;
    this.picture = item.picture;
    this.item = item;
  }


  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }

  addItem(){
    this.itemService.addOrderedItem(this.item);
    this._snackBar.open(this.item.name, "added", {duration: 500});
  }

  cancelItem(){
    this.itemService.removeOrderedItem(this.item);
    this._snackBar.open(this.item.name, "removed", {duration: 500});
  }
}