package com.inflationmonitor.inflationmonitorserver.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    @Id
    int userId;


}
