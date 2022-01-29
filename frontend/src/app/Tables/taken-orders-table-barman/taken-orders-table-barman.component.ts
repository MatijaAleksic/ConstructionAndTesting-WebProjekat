import { DatePipe } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { OrderedItem } from 'src/app/model/ordered-item';
import { OrderedItemService } from 'src/app/services/ordered-item/ordered-item.service';

export interface PeriodicElement {
  picture: string;
  name: string;
  price: number;
}

@Component({
  selector: 'app-taken-orders-table-barman',
  templateUrl: './taken-orders-table-barman.component.html',
  styleUrls: ['./taken-orders-table-barman.component.css']
})
export class TakenOrdersTableBarmanComponent implements OnInit {

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
