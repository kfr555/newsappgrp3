import { Component, OnInit } from '@angular/core';
import { TopnewsapiService } from 'src/app/topnewsapi.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 
  constructor(private api:TopnewsapiService) { }
//dispaly data
topheadlinesData:any=[];
  ngOnInit(): void {

    this.api.tcheadlines().subscribe((result)=>{
      console.log(result.articles);
      this.topheadlinesData=result.articles;
    }
    
      
      );
    }
  
  }
  

    