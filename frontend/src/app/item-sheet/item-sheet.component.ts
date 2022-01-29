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
    console.log("Before");
    console.log(item);
    this.item.note = this.itemService.getItemNote(this.item.id);

    console.log("After");
    console.log(item);
  }


  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }

  addItem(){
    this.itemService.addOrderedItem(this.item);
    this._snackBar.open(this.item.name + " added " + this.itemService.getOrderedItem(this.item.id)?.number, "", {duration: 500});
  }

  cancelItem(){
    this.itemService.removeOrderedItem(this.item);
    this._snackBar.open(this.item.name, "removed", {duration: 500});
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