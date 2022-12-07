import { Component, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { DashboardComponent } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  show:boolean;

  @ViewChild(DashboardComponent) log:DashboardComponent;
  constructor(private router:Router) {
    this.show=false;
     
   }

  ngOnInit(): void {
    this.show=false;
    if(sessionStorage.getItem('token')==null)
    {
            this.router.navigate(['../admin']);
    }
    
  }

}