package org.oracle.imageclassification.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MODEL_CONFIG database table.
 * 
 */
@Entity
@Table(name="MODEL_CONFIG")
@NamedQuery(name="ModelConfig.findAll", query="SELECT m FROM ModelConfig m")
public class ModelConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODEL_CONFIG_MODELID_GENERATOR", sequenceName="MODEL_CONFIG_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODEL_CONFIG_MODELID_GENERATOR")
	@Column(name="MODEL_ID")
	private long modelId;

	@Column(name="LABEL_FILE_NAME")
	private String labelFileName;

	@Column(name="MODEL_FILE_NAME")
	private String modelFileName;

	@Column(name="MODEL_NAME")
	private String modelName;

	public ModelConfig() {
	}

	public long getModelId() {
		return this.modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getLabelFileName() {
		return this.labelFileName;
	}

	public void setLabelFileName(String labelFileName) {
		this.labelFileName = labelFileName;
	}

	public String getModelFileName() {
		return this.modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}