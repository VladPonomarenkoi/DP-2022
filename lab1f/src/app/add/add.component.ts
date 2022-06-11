import { Component, OnInit, Input, Output } from '@angular/core';
import { Trees } from '../interfaces/trees';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  TreesList:Trees[]=[];
  
  constructor(private service:Service1Service) { }


  ngOnInit(): void {
    
  }

  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.TreesList=rest1._embedded.treeses;
      }
    )
  }

  addRest(trees:Trees){
    this.service.postRest(trees).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
