 
package org.oracle.imageclassification.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/service")
public class ImageClassifier {
	/**
     * Default constructor. 
     */
    public ImageClassifier() {
        // TODO Auto-generated constructor stub
    }


    /**
     * Retrieves representation of an instance of ImageAnalysisService
     * @return an instance of String
     */
	@GET
	@Path("/image/{id}")
	@Produces("application/json")
	public String getImage(@PathParam("id") String id) { 
		return id;
	}

	/**
     * PUT method for updating or creating an instance of ImageAnalysisService
     * @content content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@PUT
	@Path("/image/{id}")
	@Consumes("application/json")
	public void resourceMethodPUT(String content) { 
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}