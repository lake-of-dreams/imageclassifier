package org.oracle.imageclassification.config;

import java.util.Set;
import javax.ws.rs.core.Application;

import org.oracle.imageclassification.rest.service.ImageClassifierEndPoint;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
	//Auto-generated from RESTful web service wizard
    private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();		
		resources.add(ImageClassifierEndPoint.class);
        return resources;    
    }
}