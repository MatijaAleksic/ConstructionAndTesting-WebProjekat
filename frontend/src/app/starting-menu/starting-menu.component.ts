import { DataSource } from '@angular/cdk/collections';
import {Component, ViewChild} from '@angular/core';
import {MatTable} from '@angular/material/table';
import { Observable, ReplaySubject } from 'rxjs';
import { Item } from '../model/item.model';
import { ItemService } from '../services/Items/item.service';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
  number: number;
}

/**
 * @title Adding and removing data when using an array-based datasource.
 */
@Component({
  selector: 'starting-menu.component',
  styleUrls: ['starting-menu.component.css'],
  templateUrl: 'starting-menu.component.html',
})
export class StartingMenuComponent {
  displayedColumns: string[] = ['picture', 'name', 'price', 'number'];
  dataSource: Observable<Item[]>;
  subcategories: string[];



  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  constructor(private itemService: ItemService, private _bottomSheet: MatBottomSheet ){
    
  }

  ngOnInit(){
    this.itemService.getCategories().subscribe(x=>{
      this.subcategories = x;
      this.dataSource = this.itemService.findBySubcategory(this.subcategories[0]);
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
    this.dataSource = this.itemService.findBySubcategory(button)
  }



}



@Component({
  selector: 'sheet',
  templateUrl: 'sheet.html',
})
export class BottomSheetOverviewExampleSheet {
  constructor(private itemService : ItemService, private _bottomSheetRef: MatBottomSheetRef<BottomSheetOverviewExampleSheet>) {}
  

  title: string;
  description: string;
  subcategory: string;
  picture: string;

  ngOnInit(){
    const item = this.itemService.getItem();
    this.title = item.name;
    this.description = item.description;
    this.subcategory = item.subcategory;
    this.picture = item.slika;
    console.log(item)
  }


  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }
}