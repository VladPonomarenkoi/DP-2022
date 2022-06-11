import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AddComponent } from './add/add.component';
import { Component1Component } from './component1/component1.component';
import { RmComponent } from './rm/rm.component';
import { UpdComponent } from './upd/upd.component';



@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    Component1Component,
    RmComponent,
    UpdComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
