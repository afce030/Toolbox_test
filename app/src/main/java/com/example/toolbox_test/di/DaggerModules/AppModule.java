package com.example.toolbox_test.di.DaggerModules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.toolbox_test.Model.LocalData.RoomDatabase.CarouselsDB;
import com.example.toolbox_test.Model.Repo.MainRepo;
import com.example.toolbox_test.ViewModels.CarouselViewModel;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(Application app){
        return  app;
    }

    @Singleton
    @Provides
    CarouselsDB providesDatabase(Context c){
        return Room.databaseBuilder(c, CarouselsDB.class, "Car_DB").build();
    }

    @Singleton
    @Provides
    MainRepo providesMainRepo(Context c, CarouselsDB carouselsDB){
        return new MainRepo(c, carouselsDB);
    }

    @Singleton
    @Provides
    CarouselViewModel provideViewModel(MainRepo mainRepo){
        return new CarouselViewModel(mainRepo);
    }
}
