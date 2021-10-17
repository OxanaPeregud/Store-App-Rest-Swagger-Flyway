package com.peregud.storeapp.repository;

import com.peregud.storeapp.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor<Shop> {

    @Query("select distinct d.discount as discount from Shop s left join Discount d on d.shop.id = :id")
    List<DiscountInfo> shopDiscounts(@Param("id") Integer id);
}
