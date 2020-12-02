package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BusinessLogin extends AppCompatActivity implements View.OnClickListener{
    EditText FullName;
    EditText Password;
    TextView textViewPassword;
    Button Connect;
    Button ForgotPassword;
    Button NewBusiness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        FullName = (EditText)findViewById(R.id.FullName);
        textViewPassword=(TextView)findViewById(R.id.textViewPassword);
        Password = (EditText)findViewById(R.id.Password);
        Connect=(Button)findViewById(R.id.Connect);
        ForgotPassword = (Button)findViewById(R.id.ForgotPassword);
        NewBusiness=(Button)findViewById(R.id.NewBusiness);
        Connect.setOnClickListener(this);
        ForgotPassword.setOnClickListener(this);
        NewBusiness.setOnClickListener(this);

        // Password
        // FullName


    }

    @Override
    public void onClick (View view){
        if (view ==  NewBusiness) {
            Intent intent = new Intent(this, RegisterNewBusiness.class);
            startActivity(intent);
        }
//        if (view == ForgotPassword) {
//            Intent intent = new Intent(this, .class);
//            startActivity(intent);
//        }
        if (view == Connect) {
            Intent intent = new Intent(this, BusinessPage.class);
            startActivity(intent);
        }
    }
}
