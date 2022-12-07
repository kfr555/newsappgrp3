package com.grpf.adminservices.model;

public class FavoriteNews {

	private int id;

	private String userId;
	private String title;
	private String description;
	private String content;
	private String publishedAt;
	private String sourceWebsiteName;
	private String url;
	private String urlToImage;
	public FavoriteNews() {
		super();
	}
	
	public FavoriteNews(int id, String userId, String title, String description, String content, String publishedAt,
			String sourceWebsiteName, String url, String urlToImage) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.publishedAt = publishedAt;
		this.sourceWebsiteName = sourceWebsiteName;
		this.url = url;
		this.urlToImage = urlToImage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getSourceWebsiteName() {
		return sourceWebsiteName;
	}
	public void setSourceWebsiteName(String sourceWebsiteName) {
		this.sourceWebsiteName = sourceWebsiteName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	
	
	
}
