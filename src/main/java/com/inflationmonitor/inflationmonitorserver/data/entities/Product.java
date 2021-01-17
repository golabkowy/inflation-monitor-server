package com.inflationmonitor.inflationmonitorserver.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "product")
public class Product {

    public Product() {
    }

    public Product(Shop shopID, Long id, String name, String category, Double price, Date date) {
        this.shopID = shopID;
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shopID = new Shop(1L);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @Column(name = "date")
    private Date date;
}
