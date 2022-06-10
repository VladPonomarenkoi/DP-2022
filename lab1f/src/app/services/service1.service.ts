import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Trees } from '../interfaces/trees';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  
  list = new BehaviorSubject<Trees[]>([]);
url:string="http://localhost:8080/lab1/Servlet1"

constructor(private http:HttpClient) { }
getTrees():Observable<Trees[]>{
  return this.http.get<Trees[]>(this.url);
}

postTrees(bird:Trees):Observable<Trees[]>{
  return this.http.post<Trees[]>(this.url, bird);
}
putTrees(bird:Trees):Observable<Trees[]>{
  return this.http.put<Trees[]>(this.url+"/"+bird.id, bird);
}
deleteTrees(bird:Trees):Observable<Trees[]>{
  return this.http.delete<Trees[]>(this.url+"/"+bird.id);
}
setList(list:Trees[]){
  this.list.next(list);
  }

}
