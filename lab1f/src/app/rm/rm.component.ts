import { Component, OnInit, Input, Output } from '@angular/core';
import { Trees } from '../interfaces/trees';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.scss']
})
export class RmComponent implements OnInit {
  TreesList:Trees[]=[];
  constructor(private service:Service1Service) { }



  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.TreesList=rest1._embedded.treeses;
      }
    )
  }
  


  ngOnInit(): void {
    this.getRest();
  }
  
  removeRest(trees:Trees){
    this.service.deleteRest(trees).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }
  

}
