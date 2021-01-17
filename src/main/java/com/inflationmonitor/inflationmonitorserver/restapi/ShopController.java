package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.entities.Shop;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopRepository shopRepository;

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping(value = "/")
    public String testShopBasicMapping() {
        return "basci shop mapping works";
    }

    @GetMapping(value = "/list")
    public List<Shop> listAllShops() {
        return shopRepository.findAll();
    }
}
