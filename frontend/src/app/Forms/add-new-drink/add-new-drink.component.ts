import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/model/item.model';
import { ItemConstruct } from 'src/app/model/itemConstruct';
import { DrinkService } from 'src/app/services/drink/drink-service.service';

@Component({
  selector: 'app-add-new-drink',
  templateUrl: './add-new-drink.component.html',
  styleUrls: ['./add-new-drink.component.css']
})
export class AddNewDrinkComponent implements OnInit {

  item : ItemConstruct;
  
  name : string;
  price : number;
  subcategory : string;
  priority : number;
  description : string;

  constructor(
    private drinkService : DrinkService,
    private router : Router,
  ) { }

  ngOnInit(): void {
  }

  addNew(){
    this.item = new ItemConstruct(this.name, this.price,this.subcategory, this.description, this.priority, "assets/drink.jpg")

    this.drinkService.create(this.item).subscribe(
      {
        next: data => {
          if(data !== null) {
            console.log(data);
            this.router.navigate(['barman-recipe-table'])
          }
        }
      }
    );
    }

}
