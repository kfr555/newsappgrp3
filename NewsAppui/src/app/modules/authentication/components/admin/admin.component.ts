import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from 'src/app/admin';
import { AdminService } from 'src/app/admin.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent  implements OnInit {
 admin:Admin=new Admin;
   constructor(private service:AdminService,private router:Router) { }
 
   ngOnInit(): void {
    
   }
   onLogin():void{
      this.service.isValidAdmin(this.admin).subscribe(data=>{
       if(data!=null){
         console.log(data)
         this.service.setToken(data);
         this.service.message(data).subscribe(data=>{
           alert(data);
         },error=>alert(data))
         this.router.navigate(['../dashboard/user']);
       }
       
     },error=>{
       console.log(error)
       alert('invalid')
       this.router.navigate(['../home'])
     }
     )
    
 
   }
 
 }