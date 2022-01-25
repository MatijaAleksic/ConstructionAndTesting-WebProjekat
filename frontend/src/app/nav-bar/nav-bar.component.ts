import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { AuthentitacionService } from 'src/app/services/autentication/authentitacion.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
    public router: Router,
    private authService: AuthentitacionService
  ) { }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
  }

  checkRole(role : string){
    if(localStorage.getItem('autorities') != null){
      return JSON.parse(localStorage.getItem('autorities') || '{}').some((e: { name: string; }) => e.name === role);
    }
    else{
      return false;
    }

  }

  checkIfLogged(){
    if(localStorage.getItem('loggedUser') != null){
      return true;
    }
    else{
      return false;
    }
  }

  alertuj(text : string){
    alert(text);
  }

}
