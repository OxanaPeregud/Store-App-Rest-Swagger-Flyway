package com.peregud.storeapp.specification;

import com.peregud.storeapp.domain.Shop;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ShopSpecifications {

    public static Specification<Shop> searchShop(String search) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (StringUtils.isNotBlank(search)) {
                predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                        root.get("name")), "%" + search.toLowerCase() + "%"));
                predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(
                        root.get("description")), "%" + search.toLowerCase() + "%"));
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[0]));
        };
    }
}
