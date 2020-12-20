package com.inflationmonitor.inflationmonitorserver.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="shop")
public class Shop {

    @OneToMany
    private List<Product> products;

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }


}
