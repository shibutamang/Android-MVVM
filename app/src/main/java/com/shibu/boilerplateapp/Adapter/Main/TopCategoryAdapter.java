package com.shibu.boilerplateapp.Adapter.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shibu.boilerplateapp.Model.TopCategory;
import com.shibu.boilerplateapp.R;

import java.util.ArrayList;

public class TopCategoryAdapter extends RecyclerView.Adapter<TopCategoryAdapter.MyViewHolder> {

    ArrayList<TopCategory> data;

    public TopCategoryAdapter(ArrayList<TopCategory> data) {
        this.data = data;

    }

    @Override
    public TopCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_category_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopCategoryAdapter.MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getCategory());
        holder.image.setImageResource(data.get(position).getCatImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.catTitle);
            image = itemView.findViewById(R.id.catImage);
        }
    }
}