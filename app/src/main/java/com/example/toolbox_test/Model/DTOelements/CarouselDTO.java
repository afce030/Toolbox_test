package com.example.toolbox_test.Model.DTOelements;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CarouselDTO implements Serializable {

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("items")
	private List<ItemsDTO> items;

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setItems(List<ItemsDTO> items){
		this.items = items;
	}

	public List<ItemsDTO> getItems(){
		return items;
	}
}