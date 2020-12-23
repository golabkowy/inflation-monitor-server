package com.inflationmonitor.inflationmonitorserver.data.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    protected Long id;

    @Column(name = "user_id")
    private Long author;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review")
    private String review;

    public Review() {
    }

    private Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
}
