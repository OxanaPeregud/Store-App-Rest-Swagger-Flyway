package com.peregud.storeapp.converter;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShopConverter implements Converter<Shop, ShopDto> {

    @Override
    public ShopDto convert(Shop shop) {
        ShopDto.ShopDtoBuilder builder = ShopDto.builder();
        Optional.ofNullable(shop.getId())
                .ifPresent(builder::id);
        return builder
                .name(shop.getName())
                .description(shop.getDescription())
                .email(shop.getEmail())
                .mobile(shop.getMobile())
                .build();
    }
}
