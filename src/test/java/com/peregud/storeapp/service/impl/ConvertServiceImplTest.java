package com.peregud.storeapp.service.impl;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConvertServiceImplTest {

    @Autowired
    private ConvertServiceImpl convertService;

    @Test
    void convertEntity() {
        Shop shop = new Shop();
        ShopDto shopDto = new ShopDto();
        assertEquals(shopDto, convertService.convertEntity(shop, ShopDto.class));

    }

    @Test
    void covertList() {
        List<Shop> shops = new ArrayList<>();
        List<ShopDto> shopDtos = new ArrayList<>();
        assertEquals(shopDtos, convertService.covertList(shops, Shop.class, ShopDto.class));
    }
}
