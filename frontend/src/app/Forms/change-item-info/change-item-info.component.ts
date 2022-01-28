import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Item } from 'src/app/model/item.model';
import { ItemService } from 'src/app/services/Items/item.service';

@Component({
  selector: 'app-change-item-info',
  templateUrl: './change-item-info.component.html',
  styleUrls: ['./change-item-info.component.css']
})
export class ChangeItemInfoComponent implements OnInit {

  myParam: number;
  item : Item;

  name : string;
  price : number;
  subcategory : string;
  priority : number;
  description : string;

  constructor(
    private route: ActivatedRoute,
    private itemService : ItemService,
    private router : Router,
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.myParam = params['id']);

    this.itemService.getItemById(this.myParam).subscribe( 
      res => {
        console.log(res);
        
        this.item = res;

        this.name = res.name;
        this.price = res.price;
        this.subcategory = res.subcategory;
        this.priority = res.priority;
        this.description = res.description;

      })
  }

  changeInfo(){
    this.item.price = this.price;
    this.item.name = this.name;
    this.item.description = this.description;
    this.item.subcategory = this.subcategory;
    this.item.priority = this.priority;
    
    this.itemService.updateItem(this.item).subscribe(
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
