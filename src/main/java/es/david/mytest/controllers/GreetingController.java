package es.david.mytest.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import es.david.mytest.beans.Greeting;

/*
 * 
 * The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method. 
 * @RequestMapping maps all HTTP operations by default (POST, DELETE, GET..). Use @RequestMapping(method=GET) to narrow this mapping.
 * 
 * 
 * @RequestParam binds the value of the query string parameter 'name' into the 'name' parameter of the greeting() method. 
 * 
 * 
 * The @ResponseBody annotation on the greeting method will cause Spring MVC to render the returned HttpEntity and its payload, 
 * the Greeting, directly to the response.
 * 
 * 
 * 
 * 
 * 
    @Controller is used to mark classes as Spring MVC Controller.
    @RestController does nothing more than adding the @Controller and @ResponseBody annotations
    
    @RestController =  @Controller + @ResponseBody

 *  Es decir, este mismo controller, se puede mapear con @RestController o con @Controller + @ResponseBody
 * 
 */



@Controller
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(value = "/greeting" , method=RequestMethod.GET )   //o  RequestMapping("/greeting") 
    @ResponseBody
    public HttpEntity<Greeting> greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        
        //--------------------------
        //Here you create the link pointing to the controller method and you add it to the representation model. 
        //Both linkTo(…) and methodOn(…) are static methods on ControllerLinkBuilder that allow you to fake a 
        //method invocation on the controller. 
        //
        //The LinkBuilder returned will have inspected the controller method’s mapping annotation to build up 
        //exactly the URI the method is mapped to.
        //---------------------------
     
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel()); 
        
        //le añado un link relacionado a una entidad subgreeting, (que en realidad es otro greeting)
        greeting.add(linkTo(methodOn(SubGreetingController.class).subgreeting()).withRel("ListaDeSubGreetings")); 

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
    
    /*
     * Ojo con los post!
     * No puedo emitir una peticion post desde la url del navegador, (esas siemprevan con get),
     * por eso tengo que usar herramientas tipo "Postman" (una extension de chrome) para poder hacerlo
     * o swagger. 
     * 
     * 
     */
    @RequestMapping(value = "/greeting/add" , method=RequestMethod.POST )  
    @ResponseBody
    public HttpEntity<Greeting> greetingAdd() {

    	//en realidad no lo persisto de momento
    	
        Greeting greeting = new Greeting(String.format(TEMPLATE, "POST!!!"));
        
        greeting.add(linkTo(methodOn(GreetingController.class).greeting("POST!!!")).withSelfRel()); 
        greeting.add(linkTo(methodOn(SubGreetingController.class).subgreeting()).withRel("ListaDeSubGreetings")); 

        return new ResponseEntity<Greeting>(greeting, HttpStatus.CREATED);
    }
    
    
}

