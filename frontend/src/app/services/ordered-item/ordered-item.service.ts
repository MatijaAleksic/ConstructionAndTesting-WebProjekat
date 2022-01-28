import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserId } from 'src/app/model/user-id';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { OrderedItem } from 'src/app/model/ordered-item';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderedItemService {

  private currentOrderedItemSelected : OrderedItem;

  constructor(private http: HttpClient, private router: Router) { }

  public setCurrentOrderedItem(orderedItem : OrderedItem){
    this.currentOrderedItemSelected = orderedItem;
  }

  public getCurrentOrderedItem(){
    return this.currentOrderedItemSelected;
  }

  public getOne(id : number) {
    return this.http.get<UserId>(
      `${environment.baseUrl}/${environment.orderedItems}/` + id
    );
  }

  public update(orderedItem : OrderedItem){
    return this.http.post<UserId[]>(
      `${environment.baseUrl}/${environment.orderedItems}/update`, orderedItem
    ).subscribe();

  };

  public getAll() {
    return this.http.get<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}`
    );
  }

  public create(orderedItem: OrderedItem) : Observable<OrderedItem> {
    return this.http.post<OrderedItem>(
      `${environment.baseUrl}/${environment.orderedItems}`,
      orderedItem
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.orderedItems}/delete/` +  id);
  }

}
