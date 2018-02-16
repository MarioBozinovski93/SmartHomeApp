import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod } from '@angular/http';
import 'rxjs/add/operator/map';
import { ReturnStatement } from '@angular/compiler/src/output/output_ast';
import { globalVar } from '../global-var/globar-var';
//import { resolve } from 'path';


@Injectable()
export class ApiProvider{
    apiUrl = 'http://192.168.1.100:8080';
    data:any;
    dataRooms:any;
    dataReservations:any;
    lighton:any;

    data1:any;
    user:any;
    
   public globalUser:any;
   public globalPass:any;

    constructor(public http:Http,public globalvar: globalVar){
        
    }

    getId(){
        return this.globalvar.getId();
    }
    setId(id){
        this.globalvar.setId(id);
    }
    getName(){
       return this.globalvar.getUserName();
    }
    setName(name){
        this.globalvar.setUserName(name);
    }
    getPass(){
        return this.globalvar.getUserPass();
    }

    setPass(pass){
        this.globalvar.setUserPass(pass);
    }
    


    getDevice(slot) {

        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/device/'+slot)
            .map(res => res.json())
            .subscribe(data => {
                this.data = data;
                resolve(this.data);
            });
        });
    }
    getAllDevices() {

        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/device/getall')
            .map(res => res.json())
              .subscribe(data1 => {
                this.data1 = data1;
                resolve(this.data1);
                });
          });
        }


    turnON(){
      
        
        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/user/turnON')
            
            .subscribe(lighton => {
                this.lighton = lighton;
                resolve(this.lighton);
            });
        });
    }
    turnOFF(){
      
        
        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/user/turnOFF')
            
            .subscribe(lighton => {
                this.lighton = lighton;
                resolve(this.lighton);
            });
        });
    }
   updateDeviceON(device){
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        return new Promise(resolve => {
            this.http.put(this.apiUrl+'/device/updateON', JSON.stringify(device) , { headers: headers })
            .subscribe(res => {
                console.log(res)
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }
    updateDeviceOFF(device){
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        return new Promise(resolve => {
            this.http.put(this.apiUrl+'/device/updateOFF', JSON.stringify(device) , { headers: headers })
            .subscribe(res => {
                console.log(res)
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }    
          
    getRole() {

        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/role/getall')
            .map(res => res.json())
              .subscribe(data1 => {
                this.data1 = data1;
                resolve(this.data1);
                });
          });
        }

    getUser() {

        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/user/getall')
            .map(res => res.json())
            .subscribe(data => {
                this.data = data;
                resolve(this.data);
            });
        });
    }
    getUserById(id) {

        return new Promise(resolve => {
            this.http.get(this.apiUrl+'/user/'+id)
            .map(res => res.json())
            .subscribe(data => {
                this.data = data;
                resolve(this.data);
            });
        });
    }
    

    addUser(user) {
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        console.log(user)
        return new Promise(resolve => {
            this.http.post(this.apiUrl+'/user/add', user, { headers: headers })
            .subscribe(res => {
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }

    editUser(data) {
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        console.log(data)
        return new Promise(resolve => {
            this.http.put(this.apiUrl+'/user/update',JSON.stringify(data), { headers: headers })
            .subscribe(res => {
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }

    deleteUser(data){
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        return new Promise(resolve => {
            this.http.delete(this.apiUrl+'/user/delete/'+data, { headers: headers })
            .subscribe(res => {
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }

    forgotPassword(email,username){
        let headers = new Headers({ 
            'Accept':'application/json',
            'Content-Type':'application/json',
            'Access-Control-Allow-Origin': '*'
        });
        console.log(email);
        console.log(username);
        return new Promise(resolve => {
            this.http.post(this.apiUrl+'/user/forgotpassword/'+email+'/'+username, { headers: headers })
            .subscribe(res => {
                resolve(res);
            }, (err) => {
                console.log(err);
            });
        });
    }


}