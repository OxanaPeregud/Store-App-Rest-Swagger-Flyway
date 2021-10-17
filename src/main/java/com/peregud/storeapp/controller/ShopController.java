package com.peregud.storeapp.controller;

import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.dto.ShopDto;
import com.peregud.storeapp.response.RequestResponse;
import com.peregud.storeapp.service.ShopService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @ApiOperation(value = "display info about shop")
    @ApiImplicitParam(name = "shopId", dataType = "string", paramType = "path",
            value = "id of shop for displaying info", required = true)
    @ApiResponse(code = 200, message = "Shop info was displayed")
    @GetMapping(value = "user/info-shop/{shopId}")
    public ResponseEntity<ShopDto> displayInfoShop(@PathVariable("shopId") Integer id) {
        ShopDto shop = shopService.getDtoById(id);
        return ResponseEntity.ok(shop);
    }

    @ApiOperation(value = "display all shops")
    @ApiResponse(code = 200, message = "Shops were displayed")
    @GetMapping(value = "user/display/full-shop-list")
    public ResponseEntity<Page<ShopDto>> displayShopsFullList() {
        Page<ShopDto> listShops = shopService.getAll();
        return ResponseEntity.ok(listShops);
    }

    @ApiOperation(value = "add shop")
    @ApiResponse(code = 200, message = "Shop was added")
    @PostMapping(value = "admin/add-shop/new")
    public ResponseEntity<Shop> insertShop(@RequestBody Shop shop) {
        Shop newShop = shopService.saveShop(shop);
        return ResponseEntity.ok(newShop);
    }

    @ApiOperation(value = "update shop")
    @ApiImplicitParam(name = "shopId", dataType = "string", paramType = "path",
            value = "id of shop to update", required = true)
    @ApiResponse(code = 200, message = "Shop was updated")
    @PutMapping("admin/update-shop/{shopId}")
    public ResponseEntity<ShopDto> updateShop(@PathVariable("shopId") Integer id, @RequestBody ShopDto shopDto) {
        ShopDto updatedShop = shopService.updateShop(shopDto, id);
        return ResponseEntity.ok(updatedShop);
    }

    @ApiOperation(value = "delete shop")
    @ApiImplicitParam(name = "shopId", dataType = "string", paramType = "path",
            value = "id of shop to delete", required = true)
    @ApiResponse(code = 200, message = "Shop was deleted")
    @DeleteMapping("admin/delete-shop/{shopId}")
    public ResponseEntity<RequestResponse> delete(@PathVariable("shopId") Integer id) {
        shopService.deleteShop(id);
        RequestResponse response = RequestResponse.builder()
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
}
