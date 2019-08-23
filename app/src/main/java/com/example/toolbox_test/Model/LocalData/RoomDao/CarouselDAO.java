package com.example.toolbox_test.Model.LocalData.RoomDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;

import java.util.List;

@Dao
public interface CarouselDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCar(CarouselEntity carouselEntity);

    @Delete
    void deleteCar(CarouselEntity carouselEntity);

    @Query("SELECT * FROM Carousels_table")
    LiveData<List<CarouselEntity>> getAllCarousels();

}
