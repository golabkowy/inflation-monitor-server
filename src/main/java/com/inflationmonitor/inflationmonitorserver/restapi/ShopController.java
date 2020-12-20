package com.inflationmonitor.inflationmonitorserver.restapi;

import com.inflationmonitor.inflationmonitorserver.data.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    public ShopRepository shopRepository;

    @GetMapping(value = "/")
    public String testShopBasicMapping() {
        return "basci shop mapping works";
    }
}
