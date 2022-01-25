import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CookTableComponent } from './cook/cook-table/cook-table.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { UpdateCookComponent } from './cook/update-cook/update-cook.component';
import { LoginFormComponent } from './Forms/login-form/login-form.component';

import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login', 
    pathMatch: 'full'
  },


  // { 
  //   path: 'add', 
  //   component: CreateCookComponent 
  // },

  { 
    path: 'employees', 
    component: CookTableComponent 
  },
  { 
    path: 'update/:id', 
    component: UpdateCookComponent 
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
    path: 'barmans',
    component: BarmanTableComponent,
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
