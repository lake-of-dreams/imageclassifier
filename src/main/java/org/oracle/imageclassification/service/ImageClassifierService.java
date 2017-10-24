package org.oracle.imageclassification.service;

import org.oracle.imageclassification.model.Image;
import org.oracle.imageclassification.model.ImageClassification;

import java.util.List;

public interface ImageClassifierService {
    List<ImageClassification> classify(Image image);
}
