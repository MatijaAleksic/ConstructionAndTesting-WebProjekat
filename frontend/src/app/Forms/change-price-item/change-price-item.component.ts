import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Item } from 'src/app/model/item.model';
import { ItemService } from 'src/app/services/Items/item.service';

@Component({
  selector: 'app-change-price-item',
  templateUrl: './change-price-item.component.html',
  styleUrls: ['./change-price-item.component.css']
})
export class ChangePriceItemComponent implements OnInit {

  myParam: number;
  item : Item;

  price : number;

  constructor(
    private route: ActivatedRoute,
    private itemService : ItemService,
    private router : Router,
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.myParam = params['id']);

    this.itemService.getItemById(this.myParam).subscribe( 
      res => {
        //this.validateForm.value.salary = this.user.salary;
        this.item = res;
        this.price = res.price;

      })
  }

  changePrice(){
    this.item.price = this.price;
    
    this.itemService.updateItem(this.item).subscribe(
      {
        next: data => {
          if(data !== null) {
            console.log(data);
            this.router.navigate(['items-table'])
          }
        }
      }
    );
    }

}
