 
package org.oracle.imageclassification.rest.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;
import org.oracle.imageclassification.service.ImageClassificationDataService;


@Path("/service")
public class ImageClassifierEndPoint {
    
    @Inject
    private ImageClassificationDataService imageClassificationDataService;
    
  
    @Inject
    @JMSConnectionFactory("jms/imagecf")
    JMSContext context;
 
    /**
     * Queue
     */
    @Resource(mappedName = "jms/imageq-in")
    Queue queueIn;
    
    /**
     * Queue
     */
    @Resource(mappedName = "jms/imageq-out")
    Queue queueOut;
    
	/**
     * Default constructor. 
     */
    public ImageClassifierEndPoint() {
    }


    /**
     * Retrieves representation of an instance of ImageAnalysisService
     * @return an instance of String
     */
	@GET
	@Path("/image/{id}")
	@Produces("application/json")
	public Image getImage(@PathParam("id") String id) { 
		return imageClassificationDataService.getImagesById(Long.parseLong(id)).get(0);
	}

	/**
     * PUT method for updating or creating an instance of ImageAnalysisService
     * @content content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@POST
	@Path("/image")
	@Consumes("application/json")
	public Image addImage(Image image) { 
	    context.createProducer().send(queueIn, image);
	    Image updatedImage = context.createConsumer(queueOut,"GUID="+image.getImageGuid()).receiveBody(Image.class);
	    List<ImageClassification> classficiations = updatedImage.getImageClassifications();
	    if(classficiations != null && !classficiations.isEmpty()){
	        for(ImageClassification classification : classficiations){
	            if(classification != null){
	                classification.setImage(updatedImage);
	            }
	        }
	        imageClassificationDataService.addImage(updatedImage);
	        return updatedImage;
	    }
	    return image;
	    
	}
}