import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { User } from '../modules/authentication/user';
import { News } from '../news';

@Component({
  selector: 'app-userslist',
  templateUrl: './userslist.component.html',
  styleUrls: ['./userslist.component.css']
})
export class UserslistComponent implements OnInit {

  
  public news:News[];
  public msg:any;
  constructor(private adminService:AdminService,private router:Router){
    
  }
  ngOnInit(){
      this.adminService.getAllNews().subscribe(data=>{
         alert(data+"<----")
         if(data==="undefined" || data==null){
          this.router.navigate(['../home']);
        }
         this.news=JSON.parse(data);
      },error=>{
        this.msg=error;
      })    
  }
  private getNews(){
    this.adminService.getAllNews().subscribe(data=>{
      alert(data+"<----")
      if(data==="undefined" || data==null){
        this.router.navigate(['../home']);
      }
      this.news=JSON.parse(data);
    },error=>{
      alert('error')
    })
  }


  deleteNewsById(id:any):void{
    this.adminService.deleteNewsById(id).subscribe(data=>{
      console.log(data);
      this.getNews();
    },error=>{
      console.log(error);
    })
  }
}
