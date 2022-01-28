import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/model/item.model';
import { ItemConstruct } from 'src/app/model/itemConstruct';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private http: HttpClient, private router: Router) { }

  public getOne(id : number) {
    return this.http.get<Item>(
      `${environment.baseUrl}/${environment.foods}/` + id
    );
  }

  public update(item : Item){
    return this.http.post<Item[]>(
      `${environment.baseUrl}/${environment.foods}/update`, item
    );

  };

  public getAll() {
    return this.http.get<Item[]>(
      `${environment.baseUrl}/${environment.foods}`
    );
  }

  public getAllNew() {
    return this.http.get<Item[]>(
      `${environment.baseUrl}/${environment.foods}/new`
    );
  }

  public create(item : ItemConstruct) {
    return this.http.post<Item>(
      `${environment.baseUrl}/${environment.foods}`,item
    );
  }
}
