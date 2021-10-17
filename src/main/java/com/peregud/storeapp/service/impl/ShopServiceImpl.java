package com.peregud.storeapp.service.impl;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import com.peregud.storeapp.repository.ShopRepository;
import com.peregud.storeapp.service.ConvertService;
import com.peregud.storeapp.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.peregud.storeapp.specification.ShopSpecifications.searchShop;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    private final ConvertService convertService;

    @Override
    public Page<ShopDto> getAll() {
        Page<Shop> shops = shopRepository.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id")));
        return shops.map(shop -> convertService.convertEntity(shop, ShopDto.class));
    }

    @Override
    public ShopDto getDtoById(Integer id) {
        return convertService.convertEntity(shopRepository.getById(id), ShopDto.class);
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public ShopDto updateShop(@NonNull ShopDto shopDto, Integer id) {
        ShopDto shopExisting = getDtoById(id);
        shopDto.setId(shopExisting.getId());
        return convertService.convertEntity(shopExisting, ShopDto.class);
    }

    @Override
    public List<ShopDto> findShop(String search) {
        List<Shop> shops = shopRepository.findAll(searchShop(search));
        return convertService.covertList(shops, Shop.class, ShopDto.class);
    }

    @Override
    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }
}
