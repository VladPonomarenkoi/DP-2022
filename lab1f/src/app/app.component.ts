import { Component } from '@angular/core';
import { Trees } from './interfaces/trees';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  treesList:Trees[]=[];


  constructor(private service:Service1Service){}
  getTrees():void{
    this.service.getTrees().subscribe(
      (trees)=>{
        this.treesList=trees;
      }
    )
  }
        addTrees(trees:Trees){
          this.service.setTrees(trees).subscribe(
            (trees)=>{
              console.log(trees);
              this.getTrees();
      }
    )
  }
}
