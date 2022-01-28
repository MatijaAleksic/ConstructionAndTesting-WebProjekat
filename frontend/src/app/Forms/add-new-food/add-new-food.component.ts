import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemConstruct } from 'src/app/model/itemConstruct';
import { FoodService } from 'src/app/services/food/food-service.service';

@Component({
  selector: 'app-add-new-food',
  templateUrl: './add-new-food.component.html',
  styleUrls: ['./add-new-food.component.css']
})
export class AddNewFoodComponent implements OnInit {

  item : ItemConstruct;
  
  name : string;
  price : number;
  subcategory : string;
  priority : number;
  description : string;
  
  constructor(
    private foodService : FoodService,
    private router : Router,
  ) { }

  ngOnInit(): void {
  }

  addNew(){
    this.item = new ItemConstruct(this.name, this.price,this.subcategory, this.description, this.priority, "assets/food.jpg")

    this.foodService.create(this.item).subscribe(
      {
        next: data => {
          if(data !== null) {
            console.log(data);
            this.router.navigate(['maincook-recipe-table'])
          }
        }
      }
    );
    }

}
