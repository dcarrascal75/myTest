package es.david.mytest.beans;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/*
 * 
 *... So you simply create a plain old java object extending ResourceSupport 
 *    and add the field and accessor for the content     
 *    as well as a constructor
 *    
 *    
 *    ResourceSupport permite luego hacerle el add(link) a los objetos que heredan de él
 *    
 *   
 *   @JsonCreator - signal on how Jackson can create an instance of this POJO
 *	 @JsonProperty - clearly marks what field Jackson should put this constructor argument 
 *   con esto se puede dar un nombre diferente al objeto en el json y al objeto de la clase.
 *   ¿es algo parecido a lo que hace orika?
 *
 *  (Spring will use the Jackson JSON library to automatically marshal instances into JSON.) 
 *  
 *  ----------------------
 *  
 *  @JsonRootName
 *  The @JsonRootName annotation is used – if wrapping is enabled – to specify the name of the root wrapper to be used.
 *  Wrapping means that instead of serializing a User to something like:
	
		{
		    "id": 1,
		    "name": "John"
		}
		
		It’s going to be wrapped like this:
					
		{
		    "User": {
		        "id": 1,
		        "name": "John"
		    }
		}
 * 		
 *  
 *  
 *  http://www.baeldung.com/jackson-annotations
 * 
 */

@JsonRootName("greeting")
public class Greeting extends ResourceSupport 
{

    private final String content;

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}