package org.oracle.imageclassification.service;

import java.util.List;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;
import org.oracle.imageclassification.model.ModelConfig;

public interface ImageClassificationDataService {
    public Image addImage(Image image);
    public Image updateImage(Image image);
    public void deleteImage(Image image);
    public void deleteImageById(long imageId);
    
    public ImageClassification addImageClassification(ImageClassification imageClassification);
    public ImageClassification updateImageClassification(ImageClassification imageClassification);
    public void deleteImageClassification(ImageClassification imageClassification);
    public void deleteImageClassificationById(long imageClassificationId);
    
    public ModelConfig addModelConfig(ModelConfig modelConfig);
    public ModelConfig updateModelConfig(ModelConfig modelConfig);
    public void deleteModelConfig(ModelConfig modelConfig);
    public void deleteModelConfigById(long modelConfigId);
    
    public List<Image> getImagesById(long ... imageId);
}
