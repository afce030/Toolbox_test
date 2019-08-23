package com.example.toolbox_test.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;
import com.example.toolbox_test.Model.Repo.MainRepo;
import java.util.List;

public class CarouselViewModel extends ViewModel {

    private LiveData<List<CarouselEntity>> carousels;
    private MainRepo mainRepo;

    public CarouselViewModel(MainRepo mainRepo) {

        this.mainRepo = mainRepo;
        carousels = this.mainRepo.getCarousels();

    }

    public LiveData<List<CarouselEntity>> getCarousels() {
        return carousels;
    }
}
