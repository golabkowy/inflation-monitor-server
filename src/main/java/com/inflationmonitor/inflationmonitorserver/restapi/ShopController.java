package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.entities.Shop;
import com.inflationmonitor.inflationmonitorserver.data.entities.ShopType;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ShopRepository;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ShopTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    public ShopRepository shopRepository;
    public ShopTypeRepository shopTypeRepository;

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Autowired
    public void setShopTypeRepository(ShopTypeRepository shopTypeRepository) {
        this.shopTypeRepository = shopTypeRepository;
    }

    @GetMapping(value = "/")
    public String testShopBasicMapping() {
        return "basci shop mapping works";
    }

    @GetMapping(value = "/list")
    public List<Shop> listAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping(value = "/list-shop-types", produces = "application/json")
    public List<ShopType> listAllShopTypes() {
        return shopTypeRepository.findAll();
    }

    @PostMapping(value = "/add-shop-type")
    public void addShopType(@RequestBody ShopType shopType) {
        System.out.println(shopType);

    }
}
