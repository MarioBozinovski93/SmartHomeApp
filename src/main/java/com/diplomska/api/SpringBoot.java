package com.diplomska.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mario HP
 */
@SpringBootApplication
@Controller
@RequestMapping("/")
public class SpringBoot {
    
 public static void main(String[] args) throws Exception {
       
      SpringApplication.run(SpringBoot.class, args);
        System.out.println("zdravoo");
       
       
    }


}
      

   
   

