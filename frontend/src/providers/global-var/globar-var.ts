import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod } from '@angular/http';
import 'rxjs/add/operator/map';
import { ReturnStatement } from '@angular/compiler/src/output/output_ast';
//import { resolve } from 'path';


@Injectable()
export class globalVar{
   
    
   public globalUser:any;
   public globalPass:any;
   public globalId:any;

    constructor(){
        
    }

    getId(){
        return this.globalId;
    }
    setId(id){
        this.globalId=id;
    }
    setUserName(name){

        this.globalUser=name;
    }
    getUserName(){
        return this.globalUser;
    }
    getUserPass(){
        return this.globalPass;
    }

    setUserPass(pass){
        this.globalPass=pass;
    }

}