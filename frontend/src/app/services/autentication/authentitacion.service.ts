import { Injectable } from '@angular/core';


import { BehaviorSubject } from 'rxjs';
import { UserWithToken } from 'src/app/model/user-with-token';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserLogin } from 'src/app/model/user-login';
import { environment } from 'src/environments/environment';
import { tap } from 'rxjs/operators';
import { Authority } from 'src/app/model/autority';

@Injectable({
  providedIn: 'root'
})
export class AuthentitacionService {

  //string = localStorage.getItem('loggedUser');
  loggedUser = new BehaviorSubject<UserWithToken>(JSON.parse(localStorage.getItem('loggedUser') || '{}'));

  constructor(private http: HttpClient, private router: Router) { }

  login(data: UserLogin) {
    return this.http.post<UserWithToken>(`${environment.baseUrl}/${environment.auth}/log-in`, data)
      .pipe(
        tap( resData => {
          console.log(resData);
          this.handleAuthentication(resData);
        })
      );
  }

  private handleAuthentication(
    resData: UserWithToken
  ) {
    const user = new UserWithToken(
      resData.accessToken, 
      resData.expiresIn, 
      resData.userId,
      resData.authorities);
    

    this.loggedUser.next(user);
    localStorage.setItem('loggedUser', JSON.stringify(user));
    localStorage.setItem('autorities', JSON.stringify(resData.authorities))
  }

  logout() {
    this.loggedUser.next(new UserWithToken('',0,-100,new Array<Authority>()));
    this.router.navigate(['/login']);
    localStorage.removeItem('loggedUser');
    localStorage.removeItem('autorities')
  }

  getUserId(){
    return JSON.parse(localStorage.getItem('loggedUser') || '{}').userId;
  }

  getUserRole(){
    length : Number;
    
    length = JSON.parse(localStorage.getItem('autorities') || '{}').length;
    
    return JSON.parse(localStorage.getItem('autorities') || '{}')[length-1].authority;
  }

  getAuthorizationToken(){
    if(localStorage.getItem('loggedUser') || ""){
      return JSON.parse(localStorage.getItem('loggedUser') || "").accessToken;
    }
    else{
      return false;
    }
  }

}
