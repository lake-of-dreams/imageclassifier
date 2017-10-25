package org.oracle.imageclassification.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;
import org.oracle.imageclassification.model.ModelConfig;
import org.oracle.imageclassification.service.ImageClassificationDataService;

@ApplicationScoped
public class ImageClassificationDataServiceImpl implements ImageClassificationDataService{
    private static final Logger LOG = Logger.getLogger(ImageClassificationDataServiceImpl.class.getName());
    
    @PersistenceContext(unitName = "ImageClassification")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    @Override
    public Image addImage(Image image) {
        try {
            utx.begin();
            em.persist(image);
            utx.commit();
            return image;
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
    }
    @Override
    public Image updateImage(Image image) {
        try {
            long imageId = image.getImageId();
            Image oldImage = em.find(Image.class, imageId);
            Image updatedImage = null;
            if(oldImage != null){
                utx.begin();
                updatedImage = em.merge(image);
                utx.commit();
            }
            
            return updatedImage;
          } catch (Exception ex) {
              LOG.log(Level.SEVERE, null, ex);
              throw new RuntimeException(ex);
          }
    }
    @Override
    public void deleteImage(Image image) {
        try {
            utx.begin();
            em.remove(image);
            utx.commit();
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
        
    }
    @Override
    public void deleteImageById(long imageId) {
        try {
            utx.begin();
        Query query = em.createQuery("Delete FROM Image i where i.image_id="+imageId);
        query.executeUpdate();
        utx.commit();
        } catch (Exception e) {
          LOG.log(Level.SEVERE, e.getMessage());
          throw new RuntimeException(e);
        }
        
    }
    @Override
    public ImageClassification addImageClassification(ImageClassification imageClassification) {
        try {
            utx.begin();
            em.persist(imageClassification);
            utx.commit();
            return imageClassification;
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
    }
    @Override
    public ImageClassification updateImageClassification(ImageClassification imageClassification) {
        try {
            long imageClassificationId = imageClassification.getClassificationId();
            ImageClassification oldImageClassification = em.find(ImageClassification.class, imageClassificationId);
            ImageClassification updatedImageClassification = null;
            if(oldImageClassification != null){
                utx.begin();
                updatedImageClassification = em.merge(imageClassification);
                utx.commit();
            }
            
            return updatedImageClassification;
          } catch (Exception ex) {
              LOG.log(Level.SEVERE, null, ex);
              throw new RuntimeException(ex);
          }
    }
    @Override
    public void deleteImageClassification(ImageClassification imageClassification) {
        try {
            utx.begin();
            em.remove(imageClassification);
            utx.commit();
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
        
    }
    @Override
    public void deleteImageClassificationById(long imageClassificationId) {
        try {
            utx.begin();
        Query query = em.createQuery("Delete FROM Image_CLASSIFICATION i where i.Classification_id="+imageClassificationId);
        query.executeUpdate();
        utx.commit();
        } catch (Exception e) {
          LOG.log(Level.SEVERE, e.getMessage());
          throw new RuntimeException(e);
        }
        
    }
    @Override
    public ModelConfig addModelConfig(ModelConfig modelConfig) {
        try {
            utx.begin();
            em.persist(modelConfig);
            utx.commit();
            return modelConfig;
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
    }
    
    @Override
    public ModelConfig updateModelConfig(ModelConfig modelConfig) {
        try {
            long modelConfigId = modelConfig.getModelId();
            ModelConfig oldModelConfig = em.find(ModelConfig.class, modelConfigId);
            ModelConfig updatedModelConfig = null;
            if(oldModelConfig != null){
                utx.begin();
                updatedModelConfig = em.merge(modelConfig);
                utx.commit();
            }
            
            return updatedModelConfig;
          } catch (Exception ex) {
              LOG.log(Level.SEVERE, null, ex);
              throw new RuntimeException(ex);
          }
    }
    @Override
    public void deleteModelConfig(ModelConfig modelConfig) {
        try {
            utx.begin();
            em.remove(modelConfig);
            utx.commit();
          } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
          }
        
    }
    @Override
    public void deleteModelConfigById(long modelConfigId) {
        try {
            utx.begin();
        Query query = em.createQuery("Delete FROM MODEL_CONFIG i where i.Model_Id="+modelConfigId);
        query.executeUpdate();
        utx.commit();
        } catch (Exception e) {
          LOG.log(Level.SEVERE, e.getMessage());
          throw new RuntimeException(e);
        }
        
    }
    
    @Override
    public List<Image> getImagesById(long ... imageId) {
        TypedQuery<Image> query = em.createQuery("SELECT image FROM Image image WHERE image.imageId in :ids",Image.class);
        List<Long> ids = new ArrayList<>();
        for(long id : imageId){
            ids.add(id);
        }
        
        query.setParameter("ids", ids);
        List<Image> results = new ArrayList<>();
        List<Image> resultList = query.getResultList();
        if(resultList != null){
            results.addAll(resultList);
        }
        LOG.log(Level.INFO,"coming here");
        return results;
    }
    @Override
    public List<ModelConfig> getModelConfigs() {
        TypedQuery<ModelConfig> query = em.createQuery("SELECT modelConfig FROM ModelConfig modelConfig",ModelConfig.class);
        return query.getResultList();
    }
    
    

}
