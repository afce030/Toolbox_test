package com.example.toolbox_test.Model.DTOelements;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ItemsDTO implements Serializable {

	@SerializedName("Video")
	private String video;

	@SerializedName("title")
	private String title;

	@SerializedName("Url")
	private String url;

	public void setVideo(String video){
		this.video = video;
	}

	public String getVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}