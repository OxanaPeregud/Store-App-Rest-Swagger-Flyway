package com.peregud.storeapp.converter;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShopDtoConverter implements Converter<ShopDto, Shop> {

    @Override
    public Shop convert(ShopDto shopDto) {
        Shop.ShopBuilder builder = Shop.builder();
        Optional.ofNullable(shopDto.getId())
                .ifPresent(builder::id);
        return builder
                .name(shopDto.getName())
                .description(shopDto.getDescription())
                .email(shopDto.getEmail())
                .mobile(shopDto.getMobile())
                .address(shopDto.getAddress())
                .build();
    }
}
