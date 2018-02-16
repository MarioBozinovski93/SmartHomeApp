import { Component } from '@angular/core';


import 'rxjs/add/operator/map';
import { Headers } from '@angular/http';
import { ApiProvider } from '../../providers/api-provider/api-provider';
import {IonicPage, NavController, NavParams, MenuController, ModalController, ViewController } from 'ionic-angular';
import { HomePage } from '../home/home';
import {FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { resolve } from 'url';
// import { parse } from 'path';

@Component({
  selector: 'page-status',
  templateUrl: 'status.html',
  providers: [ApiProvider]
})
export class StatusPage {
  public isToggled: boolean;
  device:any;
  deviceUpdate:any;
  public statusToggle: boolean;
  public deviceslot:any;
  
  constructor(public navCtrl: NavController,public apiProvider: ApiProvider ) {
  
    
      this.apiProvider.getDevice(4).then((value) =>{
        this.deviceslot=value;
        console.log(this.deviceslot.status);
        this.statusToggle = this.deviceslot.status;
       this.status.Device4=String(this.statusToggle); 
      })
       
       
   
  }
public status = {
  Device4:"this.statusToggle"
};


turnOnOff(){
  if(this.statusToggle==false){
    console.log("prikluci");
    this.statusToggle=true;
    this.apiProvider.getDevice(4).then((value) => {
      this.device=value;
      this.device.status=true;

     this.apiProvider.getUserById(this.apiProvider.getId()).then((value) => {
      this.deviceUpdate=value;
      
       this.device.user=this.deviceUpdate;
       console.log(this.device);
       this.apiProvider.updateDeviceON(this.device);
     })
    //  console.log(this.device.user);
    //   console.log(this.device);
     
      })
     
    

  }else{

    console.log("iskluci");
    this.statusToggle=false;
    this.apiProvider.getDevice(4).then((value) => {
      this.device=value;
      this.device.status=false;

     this.apiProvider.getUserById(this.apiProvider.getId()).then((value) => {
      this.deviceUpdate=value;
      
       this.device.user=this.deviceUpdate;
       console.log(this.device);
       this.apiProvider.updateDeviceOFF(this.device);
     })
    //  console.log(this.device.user);
    //   console.log(this.device);
     
      })
     

  }
}
turnOFF(){

this.apiProvider.turnOFF();
}

getBack(){
    
  this.navCtrl.setRoot(HomePage);
}  
  
  }

  