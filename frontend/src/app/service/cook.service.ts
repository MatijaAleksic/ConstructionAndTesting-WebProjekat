import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { ApiResponse } from '../model/api.response';
import { Cook } from '../model/cook.model';

@Injectable()
export class CookService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'http://localhost:8080/cooks/';

  

  getCook() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl);
  }

  getCookById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + id);
  }

  createCook(cook: Cook): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, cook);
  }

  updateCook(id: number, cook: Cook): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + cook.id, cook);
  }

  deleteCook(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}