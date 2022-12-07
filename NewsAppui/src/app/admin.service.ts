import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { Admin } from './admin';
import { News } from './news';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseURL="http://localhost:9000/admin/";
  private login:string="login";
  private token:any;
  constructor(private http:HttpClient,private router:Router) { }

  setToken(tok:any):void{
    this.token=tok;
    //localStorage.setItem('token',this.token);
    sessionStorage.setItem('token',tok);
  }
  getToken():any{
    //return localStorage.getItem('token');
    return localStorage.getItem('token');
  }
  getAllNews():Observable<any>{
  let tokens='Bearer '+this.token;
   alert(tokens)
    if(this.token==null){
      alert('undeifne')
      this.router.navigate(['../admin']);
      return new Observable<string>();
    }else{
      const headers=new HttpHeaders().set('Authorization',tokens);
      return this.http.get<any[]>(this.baseURL+"news",{headers,responseType:'text' as 'json'});
    }
     
 }

 saveNews(news:News):Observable<Object>{
  let tokens='Bearer '+this.token;
   const headers=new HttpHeaders().set('Authorization',tokens);
  return this.http.post(this.baseURL+"saveNews",news,{headers,responseType:'text' as 'json'});
 }

 users(id:number):Observable<News>{
  let tokens='Bearer '+this.token;
  const headers=new HttpHeaders().set('Authorization',tokens);
   return this.http.get<News>(`${this.baseURL}${this.users}`,{headers,responseType:'text' as 'json'});
 }


 deleteNewsById(id:number):Observable<any>{
  let tokens='Bearer '+this.token;
  const headers=new HttpHeaders().set('Authorization',tokens);
  return this.http.delete(`${this.baseURL}${this.deleteNewsById}`,{headers,responseType:'text' as 'json'});
 }

 isValidAdmin(admin:Admin):Observable<any>{
  return this.http.put(`${this.baseURL}${this.login}`,admin,{responseType:'text' as 'json'});
 }

 message(token:any){
   let tokens='Bearer '+token;
   const headers=new HttpHeaders().set('Authorization',tokens);
   return this.http.get(this.baseURL+"msg",{headers,responseType:'text' as 'json'});
 }
}