import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { ApiResponse } from '../model/api.response';
import { Cook } from '../model/cook.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'http://localhost:8080/cooks/';

  

  getCook() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl);
  }

  getCookById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + id);
  }

  createCook(employee: Cook): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, cook);
  }

  updateCook(id: number, employee: Cook): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + cook.id, cook);
  }

  deleteEmployee(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}