package com.peregud.storeapp.config;

import com.peregud.storeapp.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ShopConverter());
        service.addConverter(new ShopDiscountListConverter());
        service.addConverter(new ShopListConverter());
        service.addConverter(new ShopSearchListConverter());
        service.addConverter(new ShopDtoConverter());
        return service;
    }
}
