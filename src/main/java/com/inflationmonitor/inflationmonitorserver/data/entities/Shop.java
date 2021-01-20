package com.inflationmonitor.inflationmonitorserver.data.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop")
public class Shop {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    // to name to jest nazwa klucza w TEJ encji, referencedColumnName to nazwa z tabeli do której
    // klucz obcy prowadzi

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne //to dziala - ciekawe czy ma to wpływ na parsowanie? mozliwe ze jackson płącze bo nie mzoe sparsować czegoś co nie dostał - otóż to,
    // jesli jest LAZY to nie działa
    @JoinColumn(name = "shop_type_id", referencedColumnName = "id")
    private ShopType type;
//    @Column(name = "shop_type_id")
//    private String chuj;

    public Shop() {
    }

    public Shop(Long id) {
        this.id = id;
    }

    public void setType(ShopType type) {
        this.type = type;
    }

    public ShopType getType() {
        return type;
    }

    public Shop(Long id, String name, ShopType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
