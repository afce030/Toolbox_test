package com.example.toolbox_test.View.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;
import com.example.toolbox_test.R;
import com.example.toolbox_test.View.Adapters.ParentAdapter;
import com.example.toolbox_test.ViewModels.CarouselViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    CarouselViewModel carouselViewModel;

    private RecyclerView rvCarousels;
    private ParentAdapter parentAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidInjection.inject(this);

        rvCarousels = findViewById(R.id.rvCarousels);
        parentAdapter = new ParentAdapter(new ArrayList<CarouselEntity>(),this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvCarousels.setLayoutManager(linearLayoutManager);
        rvCarousels.setAdapter(parentAdapter);

        carouselViewModel.getCarousels().observe(this, new Observer<List<CarouselEntity>>() {
            @Override
            public void onChanged(List<CarouselEntity> carouselDTOS) {
                parentAdapter.refreshAdapter(carouselDTOS);
            }
        });

    }

}
