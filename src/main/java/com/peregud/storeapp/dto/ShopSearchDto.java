package com.peregud.storeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopSearchDto {

    private Integer id;

    private String name;

    private String description;

    private String email;

    private Long mobile;

}
