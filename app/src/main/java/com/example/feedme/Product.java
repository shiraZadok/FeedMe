package com.example.feedme;

import java.util.Vector;

public class Product {
    public String ProductInfo;
    public String numProduct;
    public String Price;
    public String id;
    public String id_of_business;
    public Vector<String>category;

    public Product(String ProductInfo, String numProduct, String Price, Vector<String> category, String id_of_business) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
    }
    public Product(){

    }
}
