import { DataSource } from '@angular/cdk/collections';
import {Component, ViewChild} from '@angular/core';
import {MatTable} from '@angular/material/table';
import { Observable, ReplaySubject } from 'rxjs';
import { Item } from '../model/item.model';
import { ItemService } from '../services/profile/item.service';
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



  @ViewChild(MatTable) table: MatTable<PeriodicElement>;

  constructor(private itemService: ItemService ){
    
  }

  ngOnInit(){
    this.dataSource = this.itemService.getItems()
  }

  itemClicked(item: Item){
    console.log(item)
  }

  addData() {
    console.log(this.dataSource)
    this.table.renderRows();
    console.log(this.dataSource)
  }

  removeData() {
    this.table.renderRows();
  }
}
