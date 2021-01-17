package com.inflationmonitor.inflationmonitorserver.data.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "shop")
public class Shop {

    @OneToMany
    private List<Product> products;

    @Id
    private Long id;

    private String name;
    private String type;

    public Shop() {
    }

    public Shop(Long id) {
        this.id = id;
    }


}
