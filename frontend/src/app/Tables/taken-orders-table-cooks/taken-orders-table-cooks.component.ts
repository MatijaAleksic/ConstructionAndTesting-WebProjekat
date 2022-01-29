import { DatePipe } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OrderedItem } from 'src/app/model/ordered-item';
import { OrderedItemService } from 'src/app/services/ordered-item/ordered-item.service';
import { PeriodicElement } from '../items-table/items-table.component';


@Component({
  selector: 'app-taken-orders-table-cooks',
  templateUrl: './taken-orders-table-cooks.component.html',
  styleUrls: ['./taken-orders-table-cooks.component.css']
})
export class TakenOrdersTableCooksComponent implements OnInit {

  displayedColumns: string[] = ['picture','name', 'dateTime', 'note', 'number', 'state', 'take']; //'picture', 'name',
  dataSource: Observable<OrderedItem[]>;
  orders: OrderedItem[];

  date : Date;
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  
  constructor(
    public datepipe: DatePipe,
    private orderedItemService: OrderedItemService,
  ) { }

  ngOnInit(){
    this.dataSource = this.orderedItemService.getAllStaff(Number(localStorage.getItem('UserId')));
  }

  finishOrder(element : OrderedItem){
    element.state = "finished"
    
    this.orderedItemService.update1(element).subscribe(
      {
        next: data => {
          if(data !== null) {
            this.dataSource = this.orderedItemService.getAllStaff(Number(localStorage.getItem('UserId')));
          }
        }
      }
    );
  }

  itemClicked(item: OrderedItem){
    console.log(item)
  }

}
