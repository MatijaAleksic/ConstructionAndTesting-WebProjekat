import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './Forms/login-form/login-form.component';

import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';
import { AddNewBarmanComponent } from './Forms/add-new-barman/add-new-barman.component';
import { CookTableComponent } from './Tables/cook-table/cook-table.component';
import { AddNewCookComponent } from './Forms/add-new-cook/add-new-cook.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login', 
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginFormComponent,
  },


  {
    path: 'navbar',
    component: NavBarComponent,
  },

  {
    path: 'profile',
    component: ProfilePageComponent,
  },

  {
    path: 'change-password',
    component: ChangePasswordFormComponent,
  },

  {
    path: 'barman-table',
    component: BarmanTableComponent,
  },

  {
    path: 'add-barman',
    component: AddNewBarmanComponent,
  },

  {
    path: 'cook-table',
    component: CookTableComponent,
  },

  {
    path: 'add-cook',
    component: AddNewCookComponent,
  },

];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes) ],
  declarations: [],
  providers: [],
  // bootstrap: [AppComponent]
  exports: [RouterModule,BrowserModule ]
  
})

export class AppRoutingModule { }
