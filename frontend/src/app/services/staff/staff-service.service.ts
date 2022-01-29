import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuth } from 'src/app/model/user-auth';
import { UserId } from 'src/app/model/user-id';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  users : UserId[];

  constructor(private http: HttpClient, private router: Router) { }


  public update(user : UserId){
    return this.http.post<UserId[]>(
      `${environment.baseUrl}/${environment.staffs}/update`, user
    );

  };

  public getAllStaff() {
    return this.http.get<UserAuth[]>(
      `${environment.baseUrl}/${environment.staffs}`
    );
  }

  public getAllWaiters() {
    return this.http.get<UserAuth[]>(
      `${environment.baseUrl}/${environment.waiters}`
    );
  }
}
