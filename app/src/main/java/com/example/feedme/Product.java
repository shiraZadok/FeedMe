package com.example.feedme;

import java.util.ArrayList;
import java.util.Vector;

public class Product {
    public String ProductInfo;
    public String numProduct;
    public String Price;
    public String id;
    public String id_of_business;
    public ArrayList<String> category=new  ArrayList<String> ();

    public Product(String ProductInfo, String numProduct, String Price, ArrayList<String> category, String id_of_business) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
    }
    public Product(String ProductInfo, String numProduct, String Price, ArrayList<String> category, String id_of_business,String id_from_system) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
        this.id=id_from_system;
    }
    public Product(){

    }

    @Override
    public String toString(){
        String answer=this.category.toString();
        return "Num of Product="+this.numProduct+",id_of_business="+id_of_business+" , Product Info="+this.ProductInfo+", id="+id+", Price="+Price+", Aditional Information"+answer;
    }
}
