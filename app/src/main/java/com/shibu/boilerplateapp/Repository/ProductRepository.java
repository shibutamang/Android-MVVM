package com.shibu.boilerplateapp.Repository;

import android.arch.lifecycle.MutableLiveData;

import com.shibu.boilerplateapp.Model.Product;
import com.shibu.boilerplateapp.R;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static ProductRepository instance;
    private ArrayList<Product> dataset = new ArrayList<>();

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Product>> getProducts() {
        setProducts();

        MutableLiveData<List<Product>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setProducts() {
        dataset.add(new Product("Product 1", "Rs. 550", "Rs 600", R.mipmap.image1));
        dataset.add(new Product("Product 2", "Rs. 342", "Rs 320", R.mipmap.image2));
    }

}
