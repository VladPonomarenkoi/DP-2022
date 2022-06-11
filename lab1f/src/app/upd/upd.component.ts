import { Component, OnInit } from '@angular/core';
import { Trees } from '../interfaces/trees';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-upd',
  templateUrl: './upd.component.html',
  styleUrls: ['./upd.component.scss']
})
export class UpdComponent implements OnInit {

  TreesList:Trees[]=[];
  
  constructor(private service:Service1Service) { }


  getTrees():void{
    this.service.getTrees().subscribe(
      (trees)=>{
        this.TreesList=trees;
        this.service.setList(trees);
      }
    )
  }

  ngOnInit(): void {
    this.getTrees();
  }
  
  updateTrees(trees:Trees){
    this.service.putTrees(trees).subscribe(
      ()=>{
        this.getTrees();
      }
    )
  }

}
