package com.sparta.apiclient;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChuckObject{

	@JsonProperty("icon_url")
	private String iconUrl;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("categories")
	private List<Object> categories;

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private String value;

	@JsonProperty("url")
	private String url;

	public String getIconUrl(){
		return iconUrl;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public List<Object> getCategories(){
		return categories;
	}

	public String getId(){
		return id;
	}

	public String getValue(){
		return value;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"ChuckObject{" + 
			"icon_url = '" + iconUrl + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",categories = '" + categories + '\'' + 
			",id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}