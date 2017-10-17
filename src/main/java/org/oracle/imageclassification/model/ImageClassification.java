package org.oracle.imageclassification.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the IMAGE_CLASSIFICATION database table.
 * 
 */
@Entity
@Table(name="IMAGE_CLASSIFICATION")
@NamedQuery(name="ImageClassification.findAll", query="SELECT i FROM ImageClassification i")
public class ImageClassification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMAGE_CLASSIFICATION_CLASSIFICATIONID_GENERATOR", sequenceName="IMAGE_CLASSIFICATION_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMAGE_CLASSIFICATION_CLASSIFICATIONID_GENERATOR")
	@Column(name="CLASSIFICATION_ID")
	private long classificationId;

	@Column(name="CLASSIFICATION_LABEL")
	private String classificationLabel;

	@Column(name="CLASSIFICATION_SCORE")
	private double classificationScore;

	//bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name="IMAGE_ID")
	private Image image;

	//uni-directional one-to-one association to ModelConfig
	@OneToOne
	@JoinColumn(name="MODEL_ID")
	private ModelConfig modelConfig;

	public ImageClassification() {
	}

	public long getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(long classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationLabel() {
		return this.classificationLabel;
	}

	public void setClassificationLabel(String classificationLabel) {
		this.classificationLabel = classificationLabel;
	}

	public double getClassificationScore() {
		return this.classificationScore;
	}

	public void setClassificationScore(double classificationScore) {
		this.classificationScore = classificationScore;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ModelConfig getModelConfig() {
		return this.modelConfig;
	}

	public void setModelConfig(ModelConfig modelConfig) {
		this.modelConfig = modelConfig;
	}

}