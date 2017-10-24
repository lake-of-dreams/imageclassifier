package org.oracle.imageclassification.mdb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;
import org.oracle.imageclassification.service.ImageClassifierService;
import org.oracle.imageclassification.util.Property;



/**
 * Message-Driven Bean implementation class for: ImageProcessorBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/imageq-in"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "jms/imageq-in")
public class ImageProcessorBean implements MessageListener {

    
    @Inject
    private ImageClassifierService imageClassifierService;
    
    @Inject
    @JMSConnectionFactory("jms/imagecf")
    JMSContext context;
 
    @Resource(mappedName = "jms/imageq-out")
    Queue queueOut;
    
    
   
    
    /**
     * Default constructor. 
     */
    public ImageProcessorBean() {
        
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
            Image image = message.getBody(Image.class);
            List<ImageClassification> classififcations = imageClassifierService.classify(image);
            if(classififcations!=null && !classififcations.isEmpty()){
                image.setImageClassifications(classififcations);
                context.createProducer().setProperty("GUID", image.getImageGuid()).send(queueOut, image);
            }
            
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
