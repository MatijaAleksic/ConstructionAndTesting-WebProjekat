import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  userActivities: any = [];

  date : Date = new Date();
  text : string = "Neko je nesto uradio!";


    constructor() {} //private acct: AccountService, private toastr: ToastrService) {}

    ngOnInit(): void {
        this.loadUserActivity();
    }

    loadUserActivity() {
        // this.acct
        //     .getUserActivity()
        //     .toPromise()
        //     .then((result) => {
        //         this.userActivities = result.data;
        //         this.toastr.success(result.message);
        //     });
    }

}
