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

  getTrees():void{
    this.service.getTrees().subscribe(
      (trees)=>{
        this.TreesList=trees;
        this.service.setList(trees);
      }
    )
  }

  addTrees(trees:Trees){
    this.service.postTrees(trees).subscribe(
      ()=>{
        this.getTrees();
      }
    )
  }

}
