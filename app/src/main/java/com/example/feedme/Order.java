package com.example.feedme;

public class Order {
    public String id_of_business_item;
    public String num_product;
    public String id_order;
    public Order(String id_of_business_item, String num_product) {
        this.id_of_business_item=id_of_business_item;
        this.num_product=num_product;
    }
    public Order(){

    }
    @Override
    public String toString(){
        return "num_product= "+num_product+",id_order= "+id_order;
    }
}
