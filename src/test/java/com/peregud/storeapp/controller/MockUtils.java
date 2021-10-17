package com.peregud.storeapp.controller;

import com.peregud.storeapp.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class MockUtils {

    public static Page<Shop> createShops() {
        List<Shop> shops = new ArrayList<>();
        shops.add(createShop("Shop 1"));
        shops.add(createShop("Shop 2"));
        return new PageImpl<>(shops);
    }

    public static Shop createShop(String name) {
        return Shop.builder().name(name).build();
    }
}
