package com.peregud.storeapp.dto;

import com.peregud.storeapp.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {

    private Integer id;

    private String name;

    private String description;

    private String email;

    private Long mobile;

    private Address address;

}
