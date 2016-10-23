package com.vzw.data.cassandra;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class DeviceFeature {
	
	@PrimaryKey
	private String id;
	private String product;
	private String detailedText;
	private String imageUrl;
	private String styleName;
	private String title;
	private String disclouserText;
	private String smallImage;
	private String imageOrVideUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDetailedText() {
		return detailedText;
	}
	public void setDetailedText(String detailedText) {
		this.detailedText = detailedText;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDisclouserText() {
		return disclouserText;
	}
	public void setDisclouserText(String disclouserText) {
		this.disclouserText = disclouserText;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getImageOrVideUrl() {
		return imageOrVideUrl;
	}
	public void setImageOrVideUrl(String imageOrVideUrl) {
		this.imageOrVideUrl = imageOrVideUrl;
	}
	
	

}
