import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserId } from 'src/app/model/user-id';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  constructor(private http: HttpClient, private router: Router) { }

  public getOne(id : number) {
    return this.http.get<UserId>(
      `${environment.baseUrl}/${environment.managers}/` + id
    );

    // return this.http.get<UserId>(`${environment.baseUrl}/${environment.managers}/` + id)
    // .map(function(res){
    //     var data = res.json();
    //     return new Book(data.id, data.title, data.pages);
    // })

    // return this.http.get<UserId>(`${environment.baseUrl}/${environment.managers}/` + id)
    // .pipe(map(data => {})).subscribe(result => {
    //   console.log(result);
    // });
  }

  public getAll() {
    return this.http.get<UserId[]>(
      `${environment.baseUrl}/${environment.managers}`
    );
  }

  public create(user: User) {
    return this.http.post(
      `${environment.baseUrl}/${environment.managers}`,
      user
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.managers}/delete/` +  id);
  }
}
