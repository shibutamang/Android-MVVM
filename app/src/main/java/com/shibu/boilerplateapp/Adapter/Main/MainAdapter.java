package com.shibu.boilerplateapp.Adapter.Main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shibu.boilerplateapp.Model.Product;
import com.shibu.boilerplateapp.Model.SpecialOffer;
import com.shibu.boilerplateapp.Model.TopCategory;
import com.shibu.boilerplateapp.R;

import java.util.ArrayList;
import java.util.List;

import static com.shibu.boilerplateapp.UI.MainActivity.getProducts;
import static com.shibu.boilerplateapp.UI.MainActivity.getSpecialOffer;
import static com.shibu.boilerplateapp.UI.MainActivity.getTopCategory;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;
    private final int HORIZONTAL1 = 1;
    private final int HORIZONTAL2 = 2;
    private final int BANNERADD_VIEW = 3;
    private final int PRODUCTS = 4;


    public MainAdapter(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }
    //this method returns the number according to the Vertical/Horizontal object
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof TopCategory)
            return HORIZONTAL1;
        if (items.get(position) instanceof SpecialOffer)
            return HORIZONTAL2;
        if (items.get(position) instanceof Integer)
            return BANNERADD_VIEW;
        if (items.get(position) instanceof Product)
            return PRODUCTS;
        return -1;
    }
    //this method returns the holder that we've inflated according to the viewtype.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case HORIZONTAL1:
                view = inflater.inflate(R.layout.top_category, parent, false);
                holder = new TopCatViewHolder(view);
                break;
            case HORIZONTAL2:
                view = inflater.inflate(R.layout.special_offer, parent, false);
                holder = new SpecOfferViewHolder(view);
                break;
            case BANNERADD_VIEW:
                view = inflater.inflate(R.layout.banner_add, parent, false);
                holder = new BannerAddViewHolder(view);
                break;
            case PRODUCTS:
                view = inflater.inflate(R.layout.products, parent, false);
                holder = new ProductsViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.top_category, parent, false);
                holder = new TopCatViewHolder(view);
                break;
        }


        return holder;
    }
    //here we bind view with data according to the position that we have defined.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == HORIZONTAL1)
            topCategoryView((TopCatViewHolder) holder);
        else if (holder.getItemViewType() == HORIZONTAL2)
            specialOfferView((SpecOfferViewHolder) holder);
        else if (holder.getItemViewType() == PRODUCTS)
            productsView((ProductsViewHolder) holder);

    }

    private void topCategoryView(TopCatViewHolder holder) {

        TopCategoryAdapter catAdapter = new TopCategoryAdapter(getTopCategory());
        holder.topCatRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.topCatRecycler.setAdapter(catAdapter);
    }


    private void specialOfferView(SpecOfferViewHolder holder) {
        SpecialOfferAdapter specOfferAdapter = new SpecialOfferAdapter(getSpecialOffer());
        holder.specialOffRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.specialOffRecycler.setAdapter(specOfferAdapter);
    }

    private void productsView(ProductsViewHolder holder) {
        ProductsAdapter productsAdapter = new ProductsAdapter(getProducts());
        holder.productRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.productRecycler.setAdapter(productsAdapter);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TopCatViewHolder extends RecyclerView.ViewHolder {

        RecyclerView topCatRecycler;

        TopCatViewHolder(View itemView) {
            super(itemView);
            topCatRecycler = itemView.findViewById(R.id.topCatRecycler);
        }
    }

    public class SpecOfferViewHolder extends RecyclerView.ViewHolder {
        RecyclerView specialOffRecycler;

        SpecOfferViewHolder(View itemView) {
            super(itemView);
            specialOffRecycler = itemView.findViewById(R.id.specialOfferRecycler);
        }
    }

    public class BannerAddViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImage;

        BannerAddViewHolder(View itemView) {
            super(itemView);

            bannerImage = itemView.findViewById(R.id.bannerimg);

        }
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        RecyclerView productRecycler;

        ProductsViewHolder(View itemView) {
            super(itemView);

            productRecycler = itemView.findViewById(R.id.productRecycler);

        }
    }


}