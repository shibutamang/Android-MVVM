package com.shibu.boilerplateapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shibu.boilerplateapp.Model.TopCategory;
import com.shibu.boilerplateapp.R;

import java.util.List;

public class TopCategoryAdapter extends RecyclerView.Adapter<TopCategoryAdapter.ViewHolder> {

    private List<TopCategory> topCategories;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public TopCategoryAdapter(Context context, List<TopCategory> topCategories) {
        this.mInflater = LayoutInflater.from(context);
        this.topCategories = topCategories;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.top_category_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopCategory topCategory = topCategories.get(position);
        String category = topCategory.getCategory();
        int image = topCategory.getCatImage();
        holder.catImage.setImageResource(image);
        holder.category.setText(category);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return topCategories.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView catImage;
        TextView category;

        ViewHolder(View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.catImage);
            category = itemView.findViewById(R.id.catTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public TopCategory getItem(int id) {
        return topCategories.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}