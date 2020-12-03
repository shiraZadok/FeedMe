package com.example.feedme;

public class Business {
    public String BName;
    public String BPassword;
    public String  BAdress;
    public String BEmail;
    public String BPhone;
    public String Bid;

    public Business(String name, String password, String Adress, String Email, String Phone) {
        this.BName=name;
        this.BEmail=Email;
        this.BPassword=password;
        this.BPhone=Phone;
        this.BAdress=Adress;
    }
    public Business(){

    }
}
