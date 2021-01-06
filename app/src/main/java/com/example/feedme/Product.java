package com.example.feedme;

import java.util.ArrayList;
import java.util.Vector;

//This class represents all objects of type - Product
public class Product {
    public String ProductInfo;
    public String numProduct;
    public String Price;
    public String id;
    public String id_of_business;
    public ArrayList<String> category=new  ArrayList<String> ();
    public String Area;
    public int takeAway;
    public int delivery;
    public int kosher;


    public Product(String ProductInfo, String numProduct, String Price, ArrayList<String> category, String id_of_business,String area,int takeAway,int del,int kosher) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
        this.Area=area;
        this.takeAway=takeAway;
        this.delivery=del;
        this.kosher=kosher;
    }
    public Product(String ProductInfo, String numProduct, String Price, ArrayList<String> category, String id_of_business,String id_from_system,String area,int takeAway,int del,int kosher) {
        this.category=category;
        this.id_of_business=id_of_business;
        this.numProduct=numProduct;
        this.Price=Price;
        this.ProductInfo=ProductInfo;
        this.id=id_from_system;
        this.takeAway=takeAway;
        this.delivery=del;
        this.kosher=kosher;
    }
    public Product(){

    }

    @Override
    public String toString(){
        String answer=this.category.toString();
        return "Num of Product="+this.numProduct+",id_of_business="+id_of_business+" , Product Info="+this.ProductInfo+", id="+id+", Price="+Price+", Aditional Information"+answer;
    }
}
