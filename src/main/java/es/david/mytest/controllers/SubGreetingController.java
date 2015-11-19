package es.david.mytest.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.david.mytest.beans.Greeting;

/*
En realidad esta clase retorna un objeto Greeting
    @RestController =  @Controller + @ResponseBody
*/


@RestController
public class SubGreetingController {

  
    @RequestMapping(value = "/subgreeting" , method=RequestMethod.GET )   //o  RequestMapping("/greeting") 
    public HttpEntity<Greeting> subgreeting() {

    	Greeting greeting = new Greeting("SUBHello!");
    	
        greeting.add(linkTo(methodOn(SubGreetingController.class).subgreeting()).withSelfRel()); 
        
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}

