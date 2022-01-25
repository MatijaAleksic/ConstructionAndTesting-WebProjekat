import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { tap } from 'rxjs';
import { ChangePasswordResponse } from 'src/app/model/api.response';
import { PasswordChanger } from 'src/app/model/password-changer';
import { User } from 'src/app/model/user';
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private router: Router) {}

  public findOne(id : string) {
    return this.http.get<User>(
      `${environment.baseUrl}/${environment.users}/${id}`);
  }

  public chagePassword(passwordChanger : PasswordChanger){
    return this.http.post<ChangePasswordResponse>(
      `${environment.baseUrl}/${environment.auth}/change-password`, passwordChanger);
  }
}
