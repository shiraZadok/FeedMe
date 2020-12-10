package com.example.feedme;

import android.widget.EditText;

public class Order {
    public String id_of_business_item;
    public String num_product;
    public String id_order;
    public String newname;
    public String newphone;
    public String newemail;
    public String newadress;
    public String newremark;
    public Order(String id_of_business_item, String num_product,String newname,String newphone,String newadress,String newremark, String newemail){
        this.id_of_business_item=id_of_business_item;
        this.num_product=num_product;
        this.newname=newname;
        this.newremark =newremark;
        this.newemail=newemail;
        this.newadress=newadress;
        this.newphone=newphone;
    }

    public Order(){

    }
    @Override
    public String toString(){
        return "num_product= "+num_product+", id_order= "+id_order+", client name="+newname+", client addres="+newadress+", client phone number="+newphone+", client email="+newemail
                +", client remarks="+newremark;
    }
}
