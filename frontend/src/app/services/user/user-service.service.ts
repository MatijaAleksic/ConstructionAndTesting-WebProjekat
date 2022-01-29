import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserId } from 'src/app/model/user-id';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  public update(user : UserId){
    return this.http.post<UserId[]>(
      `${environment.baseUrl}/${environment.users}/update`, user
    );

  };

  public getOne(id : number) {
    return this.http.get<UserId>(
      `${environment.baseUrl}/${environment.users}/` + id
    );
  }

  public getAll(){
    return this.http.get<UserId[]>(
      `${environment.baseUrl}/${environment.users}/`
    );
  }

  
  
}
