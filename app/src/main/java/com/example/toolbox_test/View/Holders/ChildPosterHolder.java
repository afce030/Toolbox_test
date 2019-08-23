package com.example.toolbox_test.View.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbox_test.R;

public class ChildPosterHolder extends RecyclerView.ViewHolder {

    private ImageView rivCover;
    private TextView tvMovieTitle;

    public ChildPosterHolder(@NonNull View itemView) {
        super(itemView);

        rivCover = itemView.findViewById(R.id.rivMovieImage);
        tvMovieTitle = itemView.findViewById(R.id.tvMovieName);

    }

    public ImageView getRivCover() {
        return rivCover;
    }

    public TextView getTvMovieTitle() {
        return tvMovieTitle;
    }
}
