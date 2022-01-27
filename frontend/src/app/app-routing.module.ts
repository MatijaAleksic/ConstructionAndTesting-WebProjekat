import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './Forms/login-form/login-form.component';

import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';
import { AddNewBarmanComponent } from './Forms/add-new-barman/add-new-barman.component';
import { CookTableComponent } from './Tables/cook-table/cook-table.component';
import { AddNewCookComponent } from './Forms/add-new-cook/add-new-cook.component';
import { MaincookTableComponent } from './Tables/maincook-table/maincook-table.component';
import { AddNewMaincookComponent } from './Forms/add-new-maincook/add-new-maincook.component';
import { WaiterTableComponent } from './Tables/waiter-table/waiter-table.component';
import { AddNewWaiterComponent } from './Forms/add-new-waiter/add-new-waiter.component';
import { ManagerTableComponent } from './Tables/manager-table/manager-table.component';
import { AddNewManagerComponent } from './Forms/add-new-manager/add-new-manager.component';
import { AdminTableComponent } from './Tables/admin-table/admin-table.component';
import { AddNewAdminComponent } from './Forms/add-new-admin/add-new-admin.component';
import { ChangeSalaryManagerComponent } from './Forms/change-salary-manager/change-salary-manager.component';
import { StartingMenuComponent } from './starting-menu/starting-menu.component';
import { StaffTableComponent } from './Tables/staff-table/staff-table.component';
import { ChangeSalaryUserComponent } from './Forms/change-salary-user/change-salary-user.component';

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
    path: 'menu', component: StartingMenuComponent
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

  {
    path: 'main-cook-table',
    component: MaincookTableComponent,
  },

  {
    path: 'add-main-cook',
    component: AddNewMaincookComponent,
  },

  {
    path: 'waiter-table',
    component: WaiterTableComponent,
  },

  {
    path: 'add-waiter',
    component: AddNewWaiterComponent,
  },

  {
    path: 'manager-table',
    component: ManagerTableComponent,
  },

  {
    path: 'add-manager',
    component: AddNewManagerComponent,
  },

  {
    path: 'admin-table',
    component: AdminTableComponent,
  },

  {
    path: 'add-admin',
    component: AddNewAdminComponent,
  },

  {
    path: 'edit-salary',
    component: ChangeSalaryManagerComponent,
  },

  {
    path: 'staff-table',
    component: StaffTableComponent,
  },

  {
    path: 'edit-salary-user',
    component: ChangeSalaryUserComponent,
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
