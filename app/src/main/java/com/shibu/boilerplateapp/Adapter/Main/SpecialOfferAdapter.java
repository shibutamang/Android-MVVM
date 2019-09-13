package com.shibu.boilerplateapp.Adapter.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shibu.boilerplateapp.Model.SpecialOffer;
import com.shibu.boilerplateapp.R;

import java.util.ArrayList;

public class SpecialOfferAdapter extends RecyclerView.Adapter<SpecialOfferAdapter.MyViewHolder> {

    ArrayList<SpecialOffer> data;

    public SpecialOfferAdapter(ArrayList<SpecialOffer> data) {
        this.data = data;

    }

    @Override
    public SpecialOfferAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_offers_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpecialOfferAdapter.MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getProductName());
        holder.image.setImageResource(data.get(position).getProductImage());
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
            title = itemView.findViewById(R.id.productName);
            image = itemView.findViewById(R.id.productImage);
        }
    }
}