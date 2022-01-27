import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from './Forms/login-form/login-form.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { AuthInterceptor } from './services/autentication/auth.interceptor';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';
import { StartingMenuComponent } from './starting-menu/starting-menu.component';
import { MatTableModule } from '@angular/material/table';
import { AddNewBarmanComponent } from './Forms/add-new-barman/add-new-barman.component';
import { AddNewCookComponent } from './Forms/add-new-cook/add-new-cook.component' 
import { CookTableComponent } from './Tables/cook-table/cook-table.component';
import { MaincookTableComponent } from './Tables/maincook-table/maincook-table.component';
import { AddNewMaincookComponent } from './Forms/add-new-maincook/add-new-maincook.component';
import { WaiterTableComponent } from './Tables/waiter-table/waiter-table.component';
import { AddNewWaiterComponent } from './Forms/add-new-waiter/add-new-waiter.component';
import { AddNewManagerComponent } from './Forms/add-new-manager/add-new-manager.component';
import { ManagerTableComponent } from './Tables/manager-table/manager-table.component';
import { AdminTableComponent } from './Tables/admin-table/admin-table.component';
import { AddNewAdminComponent } from './Forms/add-new-admin/add-new-admin.component';
import { ChangeSalaryManagerComponent } from './Forms/change-salary-manager/change-salary-manager.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { StaffTableComponent } from './Tables/staff-table/staff-table.component';
import { ChangeSalaryUserComponent } from './Forms/change-salary-user/change-salary-user.component'
import {MatButtonModule} from '@angular/material/button';
import { ItemsTableComponent } from './Tables/items-table/items-table.component';
import { ChangePriceItemComponent } from './Forms/change-price-item/change-price-item.component';

import {MatBottomSheet, MatBottomSheetModule, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import { BottomSheetOverviewExampleSheet } from './starting-menu/starting-menu.component';
import { NewRecipeTableComponent } from './Tables/new-recipe-table/new-recipe-table.component';

@NgModule({
  declarations: [
    AppComponent,
    CookTableComponent,
    LoginFormComponent,
    NavBarComponent,
    ProfilePageComponent,
    ChangePasswordFormComponent,
    BarmanTableComponent,
    AddNewBarmanComponent,
    AddNewCookComponent,
    MaincookTableComponent,
    AddNewMaincookComponent,
    WaiterTableComponent,
    AddNewWaiterComponent,
    AddNewManagerComponent,
    ManagerTableComponent,
    AdminTableComponent,
    AddNewAdminComponent,
    ChangeSalaryManagerComponent,
    StartingMenuComponent,
    StaffTableComponent,
    ChangeSalaryUserComponent,
    ItemsTableComponent,
    ChangePriceItemComponent,
    BottomSheetOverviewExampleSheet,
    NewRecipeTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatSidenavModule,
    MatButtonModule,
    MatCardModule,
    MatBottomSheetModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
