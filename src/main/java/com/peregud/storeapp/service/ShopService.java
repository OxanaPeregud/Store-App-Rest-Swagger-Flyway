package com.peregud.storeapp.service;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {

    Page<ShopDto> getAll();

    ShopDto getDtoById(Integer id);

    Shop saveShop(Shop shop);

    ShopDto updateShop(ShopDto shopDto, Integer id);

    List<ShopDto> findShop(String search);

    void deleteShop(Integer id);
}
