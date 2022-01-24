// import { CookService } from 'src/app/services/cook/cook.service';
// import { Cook } from 'src/app/model/cook.model';

// import { Component, OnInit } from '@angular/core';
// import {FormControl, FormGroup, Validators} from "@angular/forms";

// import {Router} from '@angular/router';


// @Component({
//   selector: 'app-create-cook',
//   templateUrl: './create-cook.component.html',
//   styleUrls: ['./create-cook.component.css']
// })
// export class CreateCookComponent implements OnInit {

//   cook: Cook = new Cook();
//   submitted = false;

//   constructor(private cookService: CookService,
//     private router: Router) { }

//   ngOnInit() {
//   }


//   onSubmit() {
//     this.submitted = true;
//     this.cookService.createCook(this.cook)
//     .subscribe((data: any) => console.log(data), (error: any) => console.log(error));
//     this.cook = new Cook();
//     this.router.navigate(['/cooks']);
//   }

 
// }