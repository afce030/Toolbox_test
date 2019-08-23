package com.example.toolbox_test.View.Holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbox_test.R;

public class ParentHolder extends RecyclerView.ViewHolder {

    private TextView tvCarouselTitle;
    private RecyclerView rvItems;

    public ParentHolder(@NonNull View itemView) {
        super(itemView);

        tvCarouselTitle = itemView.findViewById(R.id.tvCarouselTitle);
        rvItems = itemView.findViewById(R.id.rvItems);

    }

    public TextView getTvCarouselTitle() {
        return tvCarouselTitle;
    }

    public RecyclerView getRvItems() {
        return rvItems;
    }
}
