package org.oracle.imageclassification.service;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;

public interface ImageClassificationDataService {
    public Image addImage(Image image);
    public Image updateImage(Image image);
    public void deleteImage(Image image);
    
    public Image addImageClassification(ImageClassification imageClassification);
    public Image updateImageClassification(ImageClassification imageClassification);
    public void deleteImageClassification(ImageClassification imageClassification);
}
