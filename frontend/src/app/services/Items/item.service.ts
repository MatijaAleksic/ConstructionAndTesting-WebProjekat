import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/index";
import { ApiResponse } from 'src/app/model/api.response';
import { Item } from 'src/app/model/item.model';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'http://localhost:8080/items/';
  private baseUrlFood: string = 'http://localhost:8080/foods/';
  private baseUrlDrink: string = 'http://localhost:8080/drinks/';
  private currentItemSelected: Item;
  private orderedItems: Item[] = [];
  

  getItemNote(itemId : number){
    this.orderedItems = JSON.parse(localStorage.getItem('shoppingCart') || '{}');
    if(!this.orderedItems.length){
      this.orderedItems = []
    }
    for(let i = 0; i < this.orderedItems.length; i++){
      if(this.orderedItems[i].id === itemId){
        return this.orderedItems[i].note;
      }
    }
    return "";
  }

  getFoodItems(){
    const items = this.http.get<Item[]>(this.baseUrlFood);
    return items
  }

  getFoodItemsByCategory(subcategory : string){
    const items = this.http.post<Item[]>(this.baseUrlFood + "findBySubcategory", subcategory);

    items.subscribe(x => {
      console.log(x);
    })
    return items
  }

  getFoodItemsCategories(){
    const categories = this.http.get<string[]>(this.baseUrlFood + "getSubcategories");

    return categories
  }





  getDrinkItems(){
    const items = this.http.get<Item[]>(this.baseUrlDrink);
    return items
  }

  getDrinkItemsByCategory(subcategory : string){
    const items = this.http.post<Item[]>(this.baseUrlDrink + "findBySubcategory", subcategory);

    items.subscribe(x => {
      console.log(x);
    })
    return items
  }

  getDrinkItemsCategories(){
    const categories = this.http.get<string[]>(this.baseUrlDrink + "getSubcategories");

    return categories
  }

  removeAllOrderedItems(){
    this.orderedItems = []
    localStorage.setItem('shoppingCart', JSON.stringify(this.orderedItems));
  }

  addOrderedItem(item: Item) {

    this.orderedItems = JSON.parse(localStorage.getItem('shoppingCart') || '{}');
    if(!this.orderedItems.length){
      this.orderedItems = []
    }
    let i = 0;
    let foundTheItem : Boolean = false;
    for( ; i < this.orderedItems.length; i++){
      if(this.orderedItems[i].id === item.id){
        this.orderedItems[i].number++;
        foundTheItem = true;
      }
    }
    if(!foundTheItem){
      item.number = 1;
      this.orderedItems.push(item);
    }


    localStorage.setItem('shoppingCart', JSON.stringify(this.orderedItems));

  }

  removeOrderedItem(item: Item) {
    this.orderedItems = JSON.parse(localStorage.getItem('shoppingCart') || '{}');
    if(!this.orderedItems.length){
      this.orderedItems = []
    }


    let i = 0;
    for( ; i < this.orderedItems.length; i++){
      if(this.orderedItems[i].id === item.id){
        this.orderedItems.splice(i, 1);
      }
    }

    localStorage.setItem('shoppingCart', JSON.stringify(this.orderedItems));
  }

  getOrderedItems(){
    this.orderedItems = JSON.parse(localStorage.getItem('shoppingCart') || '{}');
    if(!this.orderedItems.length){
      this.orderedItems = []
    }
    return this.orderedItems;
  }


  getOrderedItem(id : number){
    this.orderedItems = JSON.parse(localStorage.getItem('shoppingCart') || '{}');
    if(!this.orderedItems.length){
      this.orderedItems = []
    }
    for( let i = 0; i < this.orderedItems.length; i++){
      if(this.orderedItems[i].id === id){
        return this.orderedItems[i];
      }
    }
    return null;
  }


  setItem(item: Item) {
    this.currentItemSelected = item;
  }

  getItem(): Item {
    return this.currentItemSelected;
  }


  getItems(): Observable<Item[]> {
    const items = this.http.get<Item[]>(this.baseUrl);
    return items
  }

  getItemsNew(): Observable<Item[]> {
    const items = this.http.get<Item[]>(this.baseUrl + "new");
    return items
  }

  getCategories(): Observable<string[]> {
    const categories = this.http.get<string[]>(this.baseUrl + "getSubcategories");

    return categories
  }

  findBySubcategory(subcategory: string): Observable<Item[]> {
    const items = this.http.post<Item[]>(this.baseUrl + "findBySubcategory", subcategory);

    items.subscribe(x => {
      console.log(x);
    })
    return items
  }

  getItemById(id: number): Observable<Item> {
    return this.http.get<Item>(this.baseUrl + id);
  }

  createItem(item: Item): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, item);
  }

  updateItem(item: Item): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/items/update`, item);
  }

  deleteItem(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}
