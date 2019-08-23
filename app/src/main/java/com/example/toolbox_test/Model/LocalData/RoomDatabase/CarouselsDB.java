package com.example.toolbox_test.Model.LocalData.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.toolbox_test.Model.LocalData.RoomDao.CarouselDAO;
import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;

@Database(entities = {CarouselEntity.class}, version = 1, exportSchema = false)
public abstract class CarouselsDB extends RoomDatabase {

    public abstract CarouselDAO carouselDAO();

}
