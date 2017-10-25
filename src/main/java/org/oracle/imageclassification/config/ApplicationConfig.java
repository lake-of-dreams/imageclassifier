package org.oracle.imageclassification.config;

import java.util.Set;

import javax.ws.rs.core.Application;

import org.oracle.imageclassification.rest.service.ImageClassifierEndPoint;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
	    Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
	    resources.add(ImageClassifierEndPoint.class);
        return resources;
    }
    
}