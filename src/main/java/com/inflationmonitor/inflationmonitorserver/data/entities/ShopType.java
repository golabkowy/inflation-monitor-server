package com.inflationmonitor.inflationmonitorserver.data.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop_type")
public class ShopType {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
