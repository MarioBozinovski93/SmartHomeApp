import { Component } from '@angular/core';
import 'rxjs/add/operator/map';
import { Headers } from '@angular/http';
import { ApiProvider } from '../../providers/api-provider/api-provider';
import { NavController, NavParams, MenuController, ModalController, AlertController } from 'ionic-angular';
import { LoginPage } from '../login/login';
import { StatusPage } from '../status/status';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Alert } from 'ionic-angular/components/alert/alert';


@Component({
  selector: 'page-createuser',
  templateUrl: 'createuser.html',
  providers: [ApiProvider]
})
export class UserPage {
   public loginForm: FormGroup;
  public  username: any;
   public password:any;
  public  useradd: {userName:string,password:string,role:{roleId:any}};
public alluser:any;
userName:any;
brojac = 0;
 
  constructor(public navCtrl: NavController,public apiProvider: ApiProvider,  formBuilder: FormBuilder,public Alert: AlertController ) {
    this.loginForm = formBuilder.group({
        username: [''],
        password: [''],
        role: [],
      });
      
    }
public createuser = {
    username:"",
    password:"",
    role: [],
   
}
getback(){
    this.navCtrl.setRoot(LoginPage);
}

create(){
    if(this.createuser.username=='' || this.createuser.password == ''){
        let alert = this.Alert.create({
            title: 'Error',
            subTitle: 'Ne se popolneti site polinja',
            buttons: ['OK']
        });
    
        alert.present();
    }else{
   
        this.apiProvider.getUser()
    .then(data1 => {
      this.userName=data1;
      for(var i=0; i<this.userName.length; i++){
        if(this.userName[i].userName == this.createuser.username)
        {
            this.brojac++;
            console.log(this.brojac);
        }
      }
      if(this.brojac>0){
        console.log(this.brojac);
        let alert = this.Alert.create({
            title: 'Error',
            subTitle: 'Postoi User so toa ime',
            buttons: ['OK']
        });
    
        alert.present();
      }else{
        console.log(this.brojac);
        this.useradd = {userName:this.createuser.username,password:this.createuser.password,role:{roleId:this.createuser.role}};
        this.apiProvider.addUser(this.useradd);
        console.log(data1);
        this.brojac=0;
      }
      this.brojac=0;
    })

}
}
}