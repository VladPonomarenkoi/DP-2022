import { Component, OnInit, Input, Output } from '@angular/core';
import { Trees } from '../interfaces/trees';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.scss']
})
export class RmComponent implements OnInit {


  

  treesList:Trees[]=[];
  constructor(private service:Service1Service) { }



  getTrees():void{
    this.service.getTrees().subscribe(
      (trees)=>{
        this.treesList=trees;
        this.service.setList(trees);
      }
    )
  }
  


  ngOnInit(): void {
    this.getTrees();
  }
  
  removeTrees(trees:Trees){
    this.service.deleteTrees(trees).subscribe(
      ()=>{
        this.getTrees();
      }
    )
  }
  

}
