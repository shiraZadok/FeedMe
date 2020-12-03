package com.example.feedme;

import android.widget.EditText;

public class Client {
    public String Name;
    public String Password;
    public String  Adress;
    public String Email;
    public String Phone;
    public String id;

    public Client(String name, String password, String Adress, String Email, String Phone) {
      this.Name=name;
      this.Email=Email;
      this.Password=password;
      this.Phone=Phone;

      this.Adress=Adress;
    }
    public Client(){

    }
}
