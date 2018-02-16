import { Component } from '@angular/core';


import 'rxjs/add/operator/map';
import { Headers } from '@angular/http';
import { ApiProvider } from '../../providers/api-provider/api-provider';
import { NavController, NavParams, MenuController, ModalController } from 'ionic-angular';
import { HomePage } from '../home/home';
import {FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { UserPage } from '../CreateUser/createuser';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
  providers: [ApiProvider]
})
export class LoginPage {
  role;
  roles:any;
  roleName:string[]=[];
  loginForm: FormGroup;
  userName:any;
  
  constructor(public navCtrl: NavController,public apiProvider: ApiProvider,  formBuilder: FormBuilder  ) {
    this.loginForm = formBuilder.group({
        username: [''],
        password: [''],
        
      });
  }  
  public login = {
    username:"",
    password:"",
  };
  createUser(){
    this.navCtrl.setRoot(UserPage);
  }
  getRole(){
   
    this.apiProvider.getRole()
  
    .then(data1 => {
      this.roles = data1;
      for(var i=0; i<this.roles.length; i++){
        if(this.roles[i].category == 1){
          this.roleName[i] = "SUPERADMIN";
          
        }else if(this.roles[i].category==2){
          this.roleName[i] = "ADMIN";
        }else if(this.roles[i].category==3){
          this.roleName[i] = "USER";
        }
        console.log(this.roleName[i]);
      }
      console.log(data1);

      this.navCtrl.setRoot(HomePage);
    });
  }
  getUser(){

    this.apiProvider.getUser()

    .then(data1 => {
      this.userName=data1;
      for(var i=0; i<this.userName.length; i++){
        if(this.userName[i].userName == this.login.username && this.userName[i].password == this.login.password)
        {
          console.log("Tocnoo");
          this.apiProvider.setName(this.userName[i].userName);
          this.apiProvider.setId(this.userName[i].userId);
           console.log(this.apiProvider.getName());
          //console.log(this.apiProvider.globalPass);
           this.navCtrl.setRoot(HomePage);
        }
      }
      console.log(data1);
    })
  }
  probaj(){
    console.log(this.apiProvider.globalUser);
  
  }

  Login(){

    var ime = this.login.username;
    var pass= this.login.password;

    console.log(ime, pass);
    this.navCtrl.setRoot(HomePage);
  }
    


  }





