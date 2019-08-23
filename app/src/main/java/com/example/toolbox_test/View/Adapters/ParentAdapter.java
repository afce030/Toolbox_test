package com.example.toolbox_test.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity;
import com.example.toolbox_test.View.Holders.ParentHolder;
import com.example.toolbox_test.R;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentHolder> {

    private List<CarouselEntity> cars;
    private Context c;

    public ParentAdapter(List<CarouselEntity> cars, Context c) {
        this.cars = cars;
        this.c = c;
    }

    public void refreshAdapter(List<CarouselEntity> cars){
        this.cars = new ArrayList<com.example.toolbox_test.Model.LocalData.RoomEntities.CarouselEntity>();
        this.cars.addAll(cars);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ParentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.parent_adapter_item, parent, false);
        return new ParentHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentHolder holder, int position) {

        holder.getTvCarouselTitle().setText(cars.get(position).getTitle());

        //Configuration of child adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(c, RecyclerView.HORIZONTAL, false);
        holder.getRvItems().setLayoutManager(linearLayoutManager);
        if(cars.get(position).getType().toLowerCase().equals("poster")) {
            ChildPosterAdapter childPosterAdapter = new ChildPosterAdapter(cars.get(position).getItems(), c);
            holder.getRvItems().setAdapter(childPosterAdapter);
        }else if(cars.get(position).getType().toLowerCase().equals("thumb")){
            ChildThumbAdapter childThumbAdapter = new ChildThumbAdapter(cars.get(position).getItems(), c);
            holder.getRvItems().setAdapter(childThumbAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
