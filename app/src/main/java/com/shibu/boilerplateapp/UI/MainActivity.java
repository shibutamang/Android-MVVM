package com.shibu.boilerplateapp.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.shibu.boilerplateapp.Adapter.Main.MainAdapter;
import com.shibu.boilerplateapp.Adapter.MainPager;
import com.shibu.boilerplateapp.Adapter.TopCategoryAdapter;
import com.shibu.boilerplateapp.Model.Product;
import com.shibu.boilerplateapp.Model.SpecialOffer;
import com.shibu.boilerplateapp.Model.TopCategory;
import com.shibu.boilerplateapp.R;
import com.shibu.boilerplateapp.ViewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private MainPager mainPager;


    private ArrayList<Object> objects = new ArrayList<>();
    private RecyclerView mainRecyclerview;

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        mainPager = new MainPager(this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(mainPager);
        circleIndicator = findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);

        mainRecyclerview = findViewById(R.id.main_recycler);

        //product viewmodel init
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        MainAdapter mainAdapter = new MainAdapter(this, getObject());
        mainRecyclerview.setAdapter(mainAdapter);
        mainRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerview.setNestedScrollingEnabled(false);

        productViewModel.getProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                mainRecyclerview.notify();
            }
        });

    }

    private ArrayList<Object> getObject() {
        objects.add(getTopCategory().get(0));
        objects.add(getBannerAdd());
        objects.add(getSpecialOffer().get(0));
        objects.add(getProducts().get(0));
        return objects;
    }

    public static ArrayList<TopCategory> getTopCategory() {

        ArrayList<TopCategory> topCategories = new ArrayList<>();
        TopCategory topCategory = new TopCategory("Phone and Tablet", R.mipmap.phones);
        topCategories.add(topCategory);

        topCategory = new TopCategory("Men's", R.mipmap.men);
        topCategories.add(topCategory);

        topCategory = new TopCategory("Women's", R.mipmap.women);
        topCategories.add(topCategory);

        topCategory = new TopCategory("Computer & Accessories", R.mipmap.pc);
        topCategories.add(topCategory);

        return topCategories;
    }

    public static int getBannerAdd() {
        int bannerAdd = R.mipmap.image1;

        return bannerAdd;
    }

    public static ArrayList<SpecialOffer> getSpecialOffer() {


        ArrayList<SpecialOffer> specialOfferArrayList = new ArrayList<>();
        SpecialOffer specialOffer = new SpecialOffer("Name 1", "220", R.mipmap.image2);
        specialOfferArrayList.add(specialOffer);

        specialOffer = new SpecialOffer("Name 1", "500", R.mipmap.image3);
        specialOfferArrayList.add(specialOffer);

        return specialOfferArrayList;
    }


    public static ArrayList<Product> getProducts() {

        ArrayList<Product> productList = new ArrayList<>();
        Product product = new Product("Product 1", "Rs. 550", "Rs. 600", R.mipmap.image1);
        productList.add(product);

        product = new Product("Product 2", "Rs. 550", "Rs. 600", R.mipmap.image2);
        productList.add(product);

        product = new Product("Product 3", "Rs. 550", "Rs. 600", R.mipmap.image3);
        productList.add(product);

        return productList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
