import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TopnewsapiService {

  constructor(private _http:HttpClient) { }

 

  topHeadlinesNews='https://newsapi.org/v2/top-headlines?country=in&apiKey=86b4358b470f4a3ba90a5a253dc02a64';

 

  tcheadlines(): Observable<any> { 

    return this._http.get(this.topHeadlinesNews)

  }
}
