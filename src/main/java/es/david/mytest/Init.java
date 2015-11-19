package es.david.mytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;


// @EnableAutoConfiguration annotation is often placed on your main class, and it implicitly defines a base “search package” for certain items.
// For example, if you are writing a JPA application, the package of the @EnableAutoConfiguration annotated class will be used to search for @Entity items.

// @Configuration :Usually the class that defines the main method is also a good candidate as the primary @Configuration.


//All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.


//Many Spring Boot developers always have their main class annotated with @Configuration, @EnableAutoConfiguration and @ComponentScan. 
//Since these annotations are so frequently used together (especially if you follow the best practices above), Spring Boot provides a 
//convenient @SpringBootApplication alternative.
//The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:

/*
@SpringBootApplication is a convenience annotation that adds all of the following:

    @Configuration tags the class as a source of bean definitions for the application context.

    @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

    Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
    This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

    @ComponentScan tells Spring to look for other components, configurations, and services in the package, allowing it to find the GreetingController.

*/



/*
9.5 Hot swapping
Since Spring Boot applications are just plain Java applications, JVM hot-swapping should work out of the box. 
JVM hot swapping is somewhat limited with the bytecode that it can replace, for a more complete solution JRebel 
or the Spring Loaded project can be used. 
The spring-boot-devtools module also includes support for quick application restarts.
*/



/*
 * Although it is possible to package this service as a traditional web application archive or WAR file for deployment to an external application server, 
 * the simpler approach demonstrated below creates a standalone application. 
 * You package everything in a single, executable JAR file, driven by a good old Java main() method. 
 * And along the way, you use Spring’s support for embedding the Tomcat servlet container as the HTTP runtime, instead of deploying to an external instance.
 */


@SpringBootApplication // equivale a @Configuration + @EnableAutoConfiguration + @ComponentScan
public class Init {

    public static void main(String[] args) throws Exception {
    	
    	//Así se ponen propiedades: System.setProperty("nombre", "valor");
    	//Con esto se podria deshabilitar el resatart enabled.
    	//System.setProperty("spring.devtools.restart.enabled", "false");
    	
    	
    	/*The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. 
    	 * Did you notice that there wasn’t a single line of XML? No web.xml file either. This web application is 100% pure Java 
    	 */
    			
        SpringApplication.run(Init.class, args);
    }
}