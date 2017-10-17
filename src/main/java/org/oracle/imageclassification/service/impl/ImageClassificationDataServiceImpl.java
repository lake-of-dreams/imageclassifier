package org.oracle.imageclassification.service.impl;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;
import org.oracle.imageclassification.service.ImageClassificationDataService;

public class ImageClassificationDataServiceImpl implements ImageClassificationDataService{
    @PersistenceContext(unitName = "ImageClassification")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    @Override
    public Image addImage(Image image) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Image updateImage(Image image) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void deleteImage(Image image) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Image addImageClassification(ImageClassification imageClassification) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Image updateImageClassification(ImageClassification imageClassification) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void deleteImageClassification(ImageClassification imageClassification) {
        // TODO Auto-generated method stub
        
    }
    
    

}
