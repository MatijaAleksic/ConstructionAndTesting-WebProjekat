import { Component, OnInit } from '@angular/core';
import { Chart, registerables, ChartConfiguration } from 'node_modules/chart.js'
import {MatDatepickerModule} from '@angular/material/datepicker';

Chart.register(...registerables);

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  constructor() { }

  myChart : Chart;
  dataToBeDisplayed : number[] = [];
  label : string;
  labels : string[] = [];
  picker : String;
  
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

    const myChart = new Chart("myChart", this.CHART_DATA);
  }

  dateRangeChange(dateRangeStart : HTMLInputElement, dateRangeEnd : HTMLInputElement){
    console.log(dateRangeStart)
    console.log(dateRangeEnd)
  }

  foodStats(){
    console.log(this.picker);
    console.log("AAAAAAAAAAAA");
  }
}
