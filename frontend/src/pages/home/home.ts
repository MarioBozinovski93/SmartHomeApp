import { Component } from '@angular/core';


import 'rxjs/add/operator/map';
import { Headers } from '@angular/http';
import { ApiProvider } from '../../providers/api-provider/api-provider';
import { NavController, NavParams, MenuController } from 'ionic-angular';
import { LoginPage } from '../login/login';
import { StatusPage } from '../status/status';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers: [ApiProvider]
})
export class HomePage {
  role;
  roles:any;
  roleName:string[]=[];

  username:any;

  constructor(public navCtrl: NavController,public apiProvider: ApiProvider,  formBuilder: FormBuilder) {
    
    }
  
  
  global(){
    
    console.log(this.apiProvider.getName());
    // console.log(this.apiProvider.globalUser);
    // console.log(this.apiProvider.globalPass);
  }
  getBack(){
    this.apiProvider.setName('');
    this.apiProvider.setPass('');
    this.navCtrl.setRoot(LoginPage);
  }
  StatusPage(){
    this.navCtrl.setRoot(StatusPage);
  }
      
  
}




