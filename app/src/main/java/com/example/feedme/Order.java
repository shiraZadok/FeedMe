package com.example.feedme;

import android.widget.EditText;

public class Order {
    public String id_of_business_item;
    public String num_product;
    public String id_order;
    public String name;
    public String phone;
    public String email;
    public String adress;
    public String remark;
    public Order(String id_of_business_item, String num_product,String name,String phone,String adress,String email){
        this.id_of_business_item=id_of_business_item;
        this.num_product=num_product;
        this.name=name;
        this.email=email;
        this.adress=adress;
        this.phone=phone;
    }

    public Order(){

    }
    @Override
    public String toString(){
        return "num_product= "+num_product+", id_order= "+id_order;

                //+", client name="+newname+", client addres="+newadress+", client phone number="+newphone+", client email="+newemail
               // +", client remarks="+newremark;
    }
}
