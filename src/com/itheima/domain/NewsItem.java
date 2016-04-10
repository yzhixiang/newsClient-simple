package com.itheima.domain;

public class NewsItem {
	
	private String title;
	private String description;
	private String image;
	private String type;
	private String comment;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "NewsItem [title=" + title + ", description=" + description
				+ ", image=" + image + ", type=" + type + ", comment="
				+ comment + "]";
	}
	
  
}
