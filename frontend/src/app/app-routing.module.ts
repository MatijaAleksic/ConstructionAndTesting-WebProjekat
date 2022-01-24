import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CookTableComponent } from './cook/cook-table/cook-table.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { UpdateCookComponent } from './cook/update-cook/update-cook.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { LoginFormComponent } from './Forms/login-form/login-form.component';
import { SuccessPageComponent } from './success-page/success-page.component';
import { HomepageComponent } from './Pages/homepage/homepage.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'homepage', 
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
    path: 'success',
    component: SuccessPageComponent,
  },
  {
    path: 'error',
    component: ErrorPageComponent,
  },

  {
    path: 'homepage',
    component: HomepageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
