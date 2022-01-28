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
  selector: 'app-orders-table-cooks',
  templateUrl: './orders-table-cooks.component.html',
  styleUrls: ['./orders-table-cooks.component.css']
})
export class OrdersTableCooksComponent implements OnInit {

  displayedColumns: string[] = [ 'dateTime', 'note', 'number', 'state', 'take']; //'picture', 'name',
  dataSource: Observable<OrderedItem[]>;
  orders: OrderedItem[];

  date : Date;
  
  @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  
  constructor(
    private router: Router,
    private orderedItemService: OrderedItemService,
  ) { }

  ngOnInit(){

    this.orderedItemService.getAllOrdered().subscribe(
          res => {
            console.log(res);
            
          }
        )
    this.dataSource = this.orderedItemService.getAllOrdered();
  }

  takeOrder(element : OrderedItem){
    element.state = "inMaking"
    //element.staff.id = Number(localStorage.getItem('UserId'));

    this.orderedItemService.update1(element).subscribe(
      {
        next: data => {
          console.log(data);
          if(data !== null) {
            this.dataSource = this.orderedItemService.getAllOrdered();
          }
        }
      }
    );
  }

  itemClicked(item: OrderedItem){
    console.log(item)
  }


}
