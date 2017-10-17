package org.oracle.imageclassification.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the IMAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMAGE_IMAGEID_GENERATOR", sequenceName="IMAGE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMAGE_IMAGEID_GENERATOR")
	@Column(name="IMAGE_ID")
	private long imageId;

	@Column(name="IMAGE_DESCRIPTION")
	private String imageDescription;

	@Column(name="IMAGE_FILE_NAME")
	private String imageFileName;

	@Column(name="IMAGE_GUID")
	private String imageGuid;

	//bi-directional many-to-one association to ImageClassification
	@OneToMany(mappedBy="image",fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
	private List<ImageClassification> imageClassifications;

	public Image() {
	}

	public long getImageId() {
		return this.imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImageDescription() {
		return this.imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageFileName() {
		return this.imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageGuid() {
		return this.imageGuid;
	}

	public void setImageGuid(String imageGuid) {
		this.imageGuid = imageGuid;
	}

	public List<ImageClassification> getImageClassifications() {
		return this.imageClassifications;
	}

	public void setImageClassifications(List<ImageClassification> imageClassifications) {
		this.imageClassifications = imageClassifications;
	}

	public ImageClassification addImageClassification(ImageClassification imageClassification) {
		getImageClassifications().add(imageClassification);
		imageClassification.setImage(this);

		return imageClassification;
	}

	public ImageClassification removeImageClassification(ImageClassification imageClassification) {
		getImageClassifications().remove(imageClassification);
		imageClassification.setImage(null);

		return imageClassification;
	}

}