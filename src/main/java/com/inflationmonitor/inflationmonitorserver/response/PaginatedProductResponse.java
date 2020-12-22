package com.inflationmonitor.inflationmonitorserver.response;

import com.inflationmonitor.inflationmonitorserver.data.entities.Product;

import java.util.List;

public class PaginatedProductResponse {
    List<Product> products;
    int customIntField;
    private String customStringField;
    double[] customDoubleArr;

    public PaginatedProductResponse(List<Product> products, int customIntField, String customStringField, double[] customDoubleArr) {
        this.products = products;
        this.customIntField = customIntField;
        this.customStringField = customStringField;
        this.customDoubleArr = customDoubleArr;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCustomIntField() {
        return customIntField;
    }

    public void setCustomIntField(int customIntField) {
        this.customIntField = customIntField;
    }

    public String getCustomStringField() {
        return customStringField;
    }

    public void setCustomStringField(String customStringField) {
        this.customStringField = customStringField;
    }

    public double[] getCustomDoubleArr() {
        return customDoubleArr;
    }

    public void setCustomDoubleArr(double[] customDoubleArr) {
        this.customDoubleArr = customDoubleArr;
    }
}
