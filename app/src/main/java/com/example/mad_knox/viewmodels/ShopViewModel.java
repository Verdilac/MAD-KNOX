package com.example.mad_knox.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mad_knox.classes.ShopRepo;
import com.example.mad_knox.models.Product;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts() {
        return shopRepo.getProducts();
    }

}