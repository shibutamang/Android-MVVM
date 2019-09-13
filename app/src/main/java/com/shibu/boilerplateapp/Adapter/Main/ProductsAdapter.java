package com.shibu.boilerplateapp.Adapter.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shibu.boilerplateapp.Model.Product;
import com.shibu.boilerplateapp.R;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    ArrayList<Product> data;

    public ProductsAdapter(ArrayList<Product> data) {
        this.data = data;

    }

    @Override
    public ProductsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getProductName());
        holder.image.setImageResource(data.get(position).getProductImaage());
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