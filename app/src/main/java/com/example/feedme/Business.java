package com.example.feedme;

import java.util.ArrayList;

//This class represents all objects of type - Business
public class Business {
    public String BName;
    public String BPassword;
    public String  BAdress;
    public String BArea;
    public String BEmail;
    public String BPhone;
    public String Bid;



    public Business(String name, String password, String Adress, String area, String Email, String Phone) {
        this.BName=name;
        this.BEmail=Email;
        this.BPassword=password;
        this.BPhone=Phone;
        this.BAdress=Adress;
        this.BArea=area;

    }
    public Business(){

    }
}
