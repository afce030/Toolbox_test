package com.example.toolbox_test.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.toolbox_test.Model.DTOelements.ItemsDTO;
import com.example.toolbox_test.View.Holders.ChildPosterHolder;
import com.example.toolbox_test.R;

import java.util.List;

public class ChildPosterAdapter extends RecyclerView.Adapter<ChildPosterHolder> {

    private List<ItemsDTO> items;
    private Context c;

    public ChildPosterAdapter(List<ItemsDTO> items, Context c) {
        this.items = items;
        this.c = c;
    }

    @NonNull
    @Override
    public ChildPosterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_poster_item, parent, false);
        return new ChildPosterHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildPosterHolder holder, final int position) {
        Glide.with(c).load(items.get(position).getUrl())
                .apply(new RequestOptions().transform(new RoundedCorners(30)))
                .into(holder.getRivCover());
        holder.getTvMovieTitle().setText(items.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, items.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
