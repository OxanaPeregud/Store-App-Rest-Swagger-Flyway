package com.peregud.storeapp.converter;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopSearchDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopSearchListConverter implements Converter<List<Shop>, List<ShopSearchDto>> {

    @Override
    public List<ShopSearchDto> convert(List<Shop> shops) {
        return shops.stream()
                .map(shop -> ShopSearchDto.builder()
                        .id(shop.getId())
                        .name(shop.getName())
                        .description(shop.getDescription())
                        .email(shop.getEmail())
                        .mobile(shop.getMobile())
                        .build())
                .collect(Collectors.toList());
    }
}
