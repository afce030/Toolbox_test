package com.example.toolbox_test.Model.Repo;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.toolbox_test.Model.DTOelements.CarouselDTO;
import com.example.toolbox_test.Model.LocalData.RoomDao.CarouselDAO;
import com.example.toolbox_test.Model.LocalData.RoomDatabase.CarouselsDB;
import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainRepo {

    private Context c;
    private CarouselsDB carouselsDB;
    private LiveData<List<CarouselEntity>> carousels;

    @Inject
    public MainRepo(Context c, CarouselsDB carouselsDB) {
        this.c = c;
        this.carouselsDB = carouselsDB;
    }

    public LiveData<List<CarouselEntity>> getCarousels() {
        refreshCars();
        return carouselsDB.carouselDAO().getAllCarousels();
    }

    void refreshCars(){

        Gson gson = new Gson();
        String json = getJsonFile("carousels.json");
        CarouselDTO[] carouselDTO = gson.fromJson(json, CarouselDTO[].class);
        List<CarouselDTO> carouselList = new ArrayList<>(Arrays.asList(carouselDTO));

        for(CarouselDTO carousel_i: carouselList){
            CarouselEntity carouselEntity = new CarouselEntity(carousel_i.getTitle(),
                    carousel_i.getType(),
                    carousel_i.getItems());

            new InsertCar(carouselsDB.carouselDAO()).execute(carouselEntity);
        }

    }

    private static class InsertCar extends AsyncTask<CarouselEntity,Void,Void>{

        private CarouselDAO carouselDAO;

        public InsertCar(CarouselDAO carouselDAO) {
            this.carouselDAO = carouselDAO;
        }

        @Override
        protected Void doInBackground(CarouselEntity... carouselEntities) {

            try {
                carouselDAO.insertCar(carouselEntities[0]);
            } catch (SQLiteConstraintException ignored){}

            return null;
        }
    }

    private String getJsonFile(String file){
        String json = null;
        try {
            InputStream inputStream = c.getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
