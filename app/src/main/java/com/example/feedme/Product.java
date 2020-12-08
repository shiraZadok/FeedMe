package com.example.feedme;

import java.util.Vector;

public class Product {
    String ProductInfo;
    String numProduct;
    String Price;
    String id_of_business;
    Vector<String>category;

    public Product(String ProductInfo, String numProduct, String Price, Vector<String> category, String id_of_business) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
    }
}
