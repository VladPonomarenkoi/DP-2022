import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Trees } from '../interfaces/trees';
import { Rest1 } from '../interfaces/rest1';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  
  url:string="http://localhost:1155/treeses";

constructor(private http:HttpClient) { }


getRest():Observable<Rest1>{
  return this.http.get<Rest1>(this.url);
}

postRest(tree:Trees):Observable<Trees>{
  return this.http.post<Trees>(this.url, tree);
}
putRest(link:string, tree:Trees):Observable<Trees>{
  return this.http.put<Trees>(link, tree);
}
deleteRest(tree:Trees):Observable<Trees>{
  return this.http.delete<Trees>(tree._links.self.href)
}

}
