package com.example.toolbox_test.Model.LocalData.RoomConverters;

import androidx.room.TypeConverter;

import com.example.toolbox_test.Model.DTOelements.ItemsDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ItemConverter {

    @TypeConverter
    public String fromItemList(List<ItemsDTO> itemDTOList) {
        if (itemDTOList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<ItemsDTO>>() {}.getType();
        String json = gson.toJson(itemDTOList, type);
        return json;
    }

    @TypeConverter
    public List<ItemsDTO> toItemList(String itemDTOString) {
        if (itemDTOString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<ItemsDTO>>() {}.getType();
        List<ItemsDTO> itemList = gson.fromJson(itemDTOString, type);
        return itemList;
    }
}