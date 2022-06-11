import { Component, OnInit } from '@angular/core';
import { Trees } from '../interfaces/trees';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-upd',
  templateUrl: './upd.component.html',
  styleUrls: ['./upd.component.scss']
})
export class UpdComponent implements OnInit {

  treesList:Trees[]=[];
  selectedItem?:Trees;
  constructor(private service:Service1Service) { }



  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.treesList=rest1._embedded.treeses;
      }
    )
  }
  
  onSelect(trees:Trees){
    this.selectedItem=trees;
  }


  ngOnInit(): void {
    this.getRest();
  }
  
  updateRest(trees:Trees){
    this.service.putRest(this.selectedItem!._links.self.href, trees).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }
  

}