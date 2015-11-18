package es.david.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// @EnableAutoConfiguration annotation is often placed on your main class, and it implicitly defines a base “search package” for certain items.
// For example, if you are writing a JPA application, the package of the @EnableAutoConfiguration annotated class will be used to search for @Entity items.

// @Configuration :Usually the class that defines the main method is also a good candidate as the primary @Configuration.


//All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.


//Many Spring Boot developers always have their main class annotated with @Configuration, @EnableAutoConfiguration and @ComponentScan. 
//Since these annotations are so frequently used together (especially if you follow the best practices above), Spring Boot provides a 
//convenient @SpringBootApplication alternative.
//The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:



/*
9.5 Hot swapping
Since Spring Boot applications are just plain Java applications, JVM hot-swapping should work out of the box. 
JVM hot swapping is somewhat limited with the bytecode that it can replace, for a more complete solution JRebel 
or the Spring Loaded project can be used. 
The spring-boot-devtools module also includes support for quick application restarts.
*/

@RestController
//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan

public class Example {

    @RequestMapping("/")
    String saludar() {
        return "Hola Spring Boot 1";
    }
    
    @RequestMapping("/manolo")
    String saludaManolo() {
        return "Hola Spring Boot 1 manolo";
    }

    @RequestMapping("/manolo2")
    String saludaManolo2() {
        return "Hola Spring Boot 2 manolo2 33 e eee  asdasd esdasdasd";
    }
    
    public static void main(String[] args) throws Exception {
    	
    	//Así se ponen propiedades: System.setProperty("nombre", "valor");
    	//Con esto se podria deshabilitar el resatart enabled.
    	//System.setProperty("spring.devtools.restart.enabled", "false");
    	
    	
        SpringApplication.run(Example.class, args);
    }
}