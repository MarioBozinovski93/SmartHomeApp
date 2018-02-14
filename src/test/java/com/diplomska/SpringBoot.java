/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
 

 

/**
 *
 * @author Mario HP
 */
@SpringBootApplication
@ComponentScan("com.diplomska.api.*")
@TestPropertySource(locations = "classpath:application.properties")
public class SpringBoot {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBoot.class, args);
        
    }
}
