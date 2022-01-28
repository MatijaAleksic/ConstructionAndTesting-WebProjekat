import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/model/item.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private http: HttpClient, private router: Router) { }

  public getOne(id : number) {
    return this.http.get<Item>(
      `${environment.baseUrl}/${environment.drinks}/` + id
    );
  }

  public update(item : Item){
    return this.http.post<Item[]>(
      `${environment.baseUrl}/${environment.drinks}/update`, item
    );

  };

  public getAll() {
    return this.http.get<Item[]>(
      `${environment.baseUrl}/${environment.drinks}`
    );
  }

  public getAllNew() {
    return this.http.get<Item[]>(
      `${environment.baseUrl}/${environment.drinks}/new`
    );
  }
}