import { DatePipe } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OrderedItem } from 'src/app/model/ordered-item';
import { UserId } from 'src/app/model/user-id';
import { OrderedItemService } from 'src/app/services/ordered-item/ordered-item.service';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

@Component({
  selector: 'app-orders-table-barman',
  templateUrl: './orders-table-barman.component.html',
  styleUrls: ['./orders-table-barman.component.css']
})
export class OrdersTableBarmanComponent implements OnInit {

  displayedColumns: string[] = ['picture','name', 'dateTime', 'note', 'number', 'state', 'take']; //'picture', 'name',
  dataSource: Observable<OrderedItem[]>;
  orders: OrderedItem[];

  date : Date;
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  
  constructor(
    private orderedItemService: OrderedItemService,
    public datepipe: DatePipe
  ) { }

  ngOnInit(){
    this.dataSource = this.orderedItemService.getAllOrderedBarman();
  }

  takeOrder(element : OrderedItem){
    element.state = "inMaking"
    element.staff = new UserId(Number(localStorage.getItem('UserId')), "", "", "", "", "", 0);
    
    this.orderedItemService.update1(element).subscribe(
      {
        next: data => {
          if(data !== null) {
            this.dataSource = this.orderedItemService.getAllOrderedBarman();
          }
        }
      }
    );
  }

  itemClicked(item: OrderedItem){
    console.log(item)
  }


}
