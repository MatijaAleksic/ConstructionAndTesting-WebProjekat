import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Order, OrderBack } from 'src/app/model/order';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  public getOne(id : number) {
    return this.http.get<Order>(
      `${environment.baseUrl}/${environment.orders}/` + id
    );
  }

  public update(user : Order){
    return this.http.post<Order[]>(
      `${environment.baseUrl}/${environment.orders}/update`, user
    ).subscribe();

  };

  public getAll() {
    return this.http.get<Order[]>(
      `${environment.baseUrl}/${environment.orders}`
    );
  }

  public create(user: OrderBack) {
    return this.http.post(
      `${environment.baseUrl}/${environment.orders}`,
      user
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.orders}/delete/` +  id);
  }

}
