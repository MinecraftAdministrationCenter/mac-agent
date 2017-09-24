package de.fastfelix771.mac.agent.endpoints.misc;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Endpoint {

	/**
	 * URL Path to the endpoint
	 */
	String value();

	/**
	 * Required HTTP Method to trigger the endpoint handler
	 */
	RequestMethod method() default RequestMethod.GET; 
	
	/**
	 * Default HTTP Status code to return <br>
	 * The endpoint handler might override this value when it executes
	 */
	int status() default 200; 

	/**
	 * Declares the API version of the endpoint
	 */
	API api() default API.GLOBAL;

}
