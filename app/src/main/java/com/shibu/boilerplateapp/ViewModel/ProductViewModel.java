package com.shibu.boilerplateapp.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.shibu.boilerplateapp.Model.Product;
import com.shibu.boilerplateapp.Repository.ProductRepository;

import java.util.List;

public class ProductViewModel  extends ViewModel {

    private MutableLiveData<List<Product>> mProducts;
    private ProductRepository productRepository;

    public void init() {
        if (mProducts != null) {
            return;
        } else {
            productRepository = ProductRepository.getInstance();
            mProducts = productRepository.getProducts();
        }
    }

    public LiveData<List<Product>> getProducts() {
        return mProducts;
    }
}
