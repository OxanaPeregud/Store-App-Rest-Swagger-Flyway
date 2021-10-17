package com.peregud.storeapp.service.impl;

import com.peregud.storeapp.controller.MockUtils;
import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import com.peregud.storeapp.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class ShopServiceImplTest {

    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void getDtoById() {
        Shop shop = MockUtils.createShop("Shop 1");
        shopRepository.save(shop);
        assertEquals("Shop 1", shopService.getDtoById(shop.getId()).getName());
    }

    @Test
    void saveShop() {
        Shop shop = new Shop();
        assertEquals(shop, shopService.saveShop(shop));
    }

    @Test
    void updateShop() {
        Shop shop = MockUtils.createShop("Shop 1");
        shopRepository.save(shop);
        ShopDto shopDto = shopService.getDtoById(shop.getId());
        assertEquals(shopDto, shopService.updateShop(shopDto, shopDto.getId()));
    }

    @Test
    void findShop() {
        Shop shop = MockUtils.createShop("Shop 1");
        shopRepository.save(shop);
        ShopDto shopDto = shopService.getDtoById(shop.getId());
        List<ShopDto> shopDtos = new ArrayList<>();
        shopDtos.add(shopDto);
        assertEquals(shopDtos, shopService.findShop("Shop 1"));
    }

    @Test
    void deleteShop() {
        Shop shop = MockUtils.createShop("Shop 1");
        shopRepository.save(shop);
        assertEquals(1, shopRepository.findAll().size());
        shopService.deleteShop(shop.getId());
        assertEquals(0, shopRepository.findAll().size());
    }
}
