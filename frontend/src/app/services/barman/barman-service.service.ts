import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserId } from 'src/app/model/user-id';
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BarmanService {

  constructor(private http: HttpClient, private router: Router) { }

  public getAll() {
    return this.http.get<UserId[]>(
      `${environment.baseUrl}/${environment.barmans}`
    );
  }

  public create(user: User) {
    return this.http.post(
      `${environment.baseUrl}/${environment.barmans}`,
      user
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.barmans}/delete/` +  id);
  }
}
