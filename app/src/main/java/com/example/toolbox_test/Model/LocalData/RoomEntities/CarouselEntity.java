package com.example.toolbox_test.Model.LocalData.RoomEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.toolbox_test.Model.DTOelements.ItemsDTO;
import com.example.toolbox_test.Model.LocalData.RoomConverters.ItemConverter;

import java.util.List;

@Entity(tableName = "Carousels_table")
public class CarouselEntity {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title")
    @NonNull
    private String title;

    @ColumnInfo(name = "type")
    private String type;

    @TypeConverters(ItemConverter.class)
    private List<ItemsDTO> items;

    public CarouselEntity(String title, String type, List<ItemsDTO> items) {
        this.title = title;
        this.type = type;
        this.items = items;
    }
    
    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public List<ItemsDTO> getItems() {
        return items;
    }
}
