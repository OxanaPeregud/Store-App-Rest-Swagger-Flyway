package com.peregud.storeapp.converter;

import com.peregud.storeapp.dto.ShopDiscountDto;
import com.peregud.storeapp.repository.ShopDiscountInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopDiscountListConverter implements Converter<List<ShopDiscountInfo>, List<ShopDiscountDto>> {

    @Override
    public List<ShopDiscountDto> convert(List<ShopDiscountInfo> shopDiscounts) {
        return shopDiscounts.stream()
                .map(shopDiscount -> ShopDiscountDto.builder()
                        .name(shopDiscount.getName())
                        .discount(shopDiscount.getDiscount())
                        .build())
                .collect(Collectors.toList());
    }
}
