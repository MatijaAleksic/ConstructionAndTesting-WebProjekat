import { Component, OnInit } from '@angular/core';
import { Chart, registerables, ChartConfiguration } from 'node_modules/chart.js'
import {MatDatepickerInputEvent, MatDatepickerModule} from '@angular/material/datepicker';
import { OrderService } from '../services/order/order.service';
import { OrderedItemService } from '../services/ordered-item/ordered-item.service';
import { ItemService } from '../services/Items/item.service';
import { OrderedItem } from '../model/ordered-item';
import { UserService } from '../services/user/user-service.service';
import { UserId } from '../model/user-id';

Chart.register(...registerables);

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  constructor(private orderService : OrderService, private orderedItemService : OrderedItemService,
    private itemService : ItemService, private userService : UserService) { }

  myChart : Chart;
  myChart2 : Chart;
  dataToBeDisplayed : number[] = [];
  dataToBeDisplayed2 : number[] = [];
  label : string;
  label2 : string;
  labels : string[] = [];
  labels2 : string[] = [];
  date1 : Date;
  date2 : Date;
  
  CHART_DATA : ChartConfiguration  = {
    type: 'bar',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
          'rgba(254, 102, 135, 252.2)',
        ]
      },
    ]
    },
    options: {
      responsive: false,
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
    
  }

  ngOnInit(): void {

    
  }

  addEvent1(event: MatDatepickerInputEvent<Date>) {
    console.log(event.value);
    if(event.value === null){
      return
    }
    this.date1 = event.value;
  }

  addEvent2(event: MatDatepickerInputEvent<Date>) {
    if(event.value === null){
      return
    }
    this.date2 = event.value;
  }

  ordersChart(){
    this.myChart?.destroy();
    this.myChart2?.destroy();
    let orderedItems : OrderedItem[];

    this.orderedItemService.getOrderedItemsByDate(this.date2, this.date1).subscribe(x=>{
      orderedItems = x;
      console.log(x);
      this.label = 'money earned';
      let dictionary : { [id: string] : number; } = {};
      let dictionary2 : { [id: string] : number; } = {};
      
      for(let i = 0; i < orderedItems.length; i++){
        if( dictionary[orderedItems[i].item.name] === undefined){
          dictionary[orderedItems[i].item.name] = 0;
          dictionary2[orderedItems[i].item.name] = 0;
          console.log("nema")
          console.log(dictionary2[orderedItems[i].item.name])
          
        }
        dictionary[orderedItems[i].item.name] += orderedItems[i].price;
        dictionary2[orderedItems[i].item.name] += orderedItems[i].number;
          console.log("ima")
          console.log(dictionary2[orderedItems[i].item.name])

      }
      this.labels = []
      this.labels2 = []
      this.dataToBeDisplayed = []
      this.dataToBeDisplayed2 = []
      for (const [key, value] of Object.entries(dictionary)) {
        this.labels.push(key);
        this.dataToBeDisplayed.push(value);
      }
      for (const [key, value] of Object.entries(dictionary2)) {
        this.labels2.push(key);
        this.dataToBeDisplayed2.push(value);
      }
      this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed;
      this.CHART_DATA.data.labels = this.labels;
      this.CHART_DATA.data.datasets[0].label = this.label;

      this.myChart = new Chart("myChart", this.CHART_DATA);
      this.label2 = "number of items"
      this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed2;
      this.CHART_DATA.data.labels = this.labels2;
      this.CHART_DATA.data.datasets[0].label = this.label2;
      this.myChart2 = new Chart("myChart2", this.CHART_DATA);
  });
    
  }


  employeesChart(){
    this.myChart?.destroy();
    this.myChart2?.destroy();
    let orderedItems : OrderedItem[];

    this.orderedItemService.getOrderedItemsByDate(this.date2, this.date1).subscribe(x=>{
      orderedItems = x;
      console.log(x);
      this.label = 'money earned';
      let dictionary : { [id: string] : number; } = {};
      let dictionary2 : { [id: string] : number; } = {};
      let dicSalary : { [id: string] : number; } = {};
      if(this.date1.getTime() > this.date2.getTime()){
        const temp = this.date2;
        this.date1 = temp;
        this.date2 = this.date1;
      }
      let Difference_In_Time = this.date2.getTime() - this.date1.getTime();
      // To calculate the no. of days between two dates
      let Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);
      
      for(let i = 0; i < orderedItems.length; i++){
        if( dictionary[orderedItems[i].staff?.username] === undefined){
          dictionary[orderedItems[i].staff?.username] = 0;
          dictionary2[orderedItems[i].staff?.username] = 0;
          dicSalary[orderedItems[i].staff?.username] = (orderedItems[i].staff?.salary / 30) * Difference_In_Days;
      }
        dictionary[orderedItems[i].staff?.username] += orderedItems[i].price;
        dictionary2[orderedItems[i].staff?.username] += orderedItems[i].number;
      }
      this.labels = []
      this.labels2 = []
      this.dataToBeDisplayed = []
      this.dataToBeDisplayed2 = []
      
      
  
      


      for (const [key, value] of Object.entries(dictionary)) {
        this.labels.push(key);
        
        this.dataToBeDisplayed.push(value - dicSalary[key]);
        
      }

      for (const [key, value] of Object.entries(dictionary2)) {
        this.labels2.push(key);
        this.dataToBeDisplayed2.push(value);
      }
      this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed;
      this.CHART_DATA.data.labels = this.labels;
      this.CHART_DATA.data.datasets[0].label = this.label;

      this.myChart = new Chart("myChart", this.CHART_DATA);

      this.label2 = "number of items"
      this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed2;
      this.CHART_DATA.data.labels = this.labels2;
      this.CHART_DATA.data.datasets[0].label = this.label2;
      this.myChart2 = new Chart("myChart2", this.CHART_DATA);

  });
    
  }







//   profitChart(){
//     this.myChart?.destroy();
//     this.myChart2?.destroy();
//     let orderedItems : OrderedItem[];

//     this.orderedItemService.getOrderedItemsByDate(this.date2, this.date1).subscribe(x=>{
//       orderedItems = x;
//       console.log(x);
//       if(this.date1.getTime() > this.date2.getTime()){
//         const temp = this.date2;
//         this.date2 = this.date1;
//         this.date1 = temp;
//       }

//       const delta = this.date2.getTime() - this.date1.getTime();
//       const splitter = 7;
//       const partOfDelta = delta / 7

//       this.userService.getAll().subscribe(q =>{
//         const users = q;
//         let pay = 0;
//         for(let i = 0; i < users.length; i++){
//           pay += users[i].salary;
//         }
//         const penalty = pay / splitter;

//         this.label = 'money earned';
//         let dictionary : [number];

//       });

      
      
//       for(let i = 0; i < orderedItems.length; i++){
//         if( dictionary[orderedItems[i].item.name] === undefined){
//           dictionary[orderedItems[i].item.name] = 0;
//           dictionary2[orderedItems[i].item.name] = 0;
//           console.log("nema")
//           console.log(dictionary2[orderedItems[i].item.name])
          
//         }
//         dictionary[orderedItems[i].item.name] += orderedItems[i].price;
//         dictionary2[orderedItems[i].item.name] += orderedItems[i].number;
//           console.log("ima")
//           console.log(dictionary2[orderedItems[i].item.name])

//       }
//       this.labels = []
//       this.labels2 = []
//       this.dataToBeDisplayed = []
//       this.dataToBeDisplayed2 = []
//       for (const [key, value] of Object.entries(dictionary)) {
//         this.labels.push(key);
//         this.dataToBeDisplayed.push(value);
//       }
//       for (const [key, value] of Object.entries(dictionary2)) {
//         this.labels2.push(key);
//         this.dataToBeDisplayed2.push(value);
//       }
//       this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed;
//       this.CHART_DATA.data.labels = this.labels;
//       this.CHART_DATA.data.datasets[0].label = this.label;

//       this.myChart = new Chart("myChart", this.CHART_DATA);
//       this.label2 = "number of items"
//       this.CHART_DATA.data.datasets[0].data = this.dataToBeDisplayed2;
//       this.CHART_DATA.data.labels = this.labels2;
//       this.CHART_DATA.data.datasets[0].label = this.label2;
//       this.myChart2 = new Chart("myChart2", this.CHART_DATA);
//   });
    
//   }
}
