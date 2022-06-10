import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trees } from '../interfaces/trees';
@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url:string="http://localhost:8080/lab1/Servlet1"

setService1Service: any;

constructor(private http:HttpClient) { }
getTrees():Observable<Trees[]>{
  return this.http.get<Trees[]>(this.url);
}

  setTrees(params: any):Observable<Object> {
    return this.http.put(this.url, {}, { params: params });
  }

}
