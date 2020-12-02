package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerLogin extends AppCompatActivity implements View.OnClickListener {
    EditText FullName;
    EditText Password;
    TextView textViewPassword;
    Button Connect;
    Button ForgotPassword;
    Button NewClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_login);
            FullName = (EditText)findViewById(R.id.FullName);
            textViewPassword=(TextView)findViewById(R.id.textViewPassword);
            Password = (EditText)findViewById(R.id.Password);
            Connect=(Button)findViewById(R.id.Connect);
            ForgotPassword = (Button)findViewById(R.id.ForgotPassword);
            NewClient=(Button)findViewById(R.id.NewBusiness);
            Connect.setOnClickListener(this);
            ForgotPassword.setOnClickListener(this);
            NewClient.setOnClickListener(this);

            // Password
            // FullName


    }

        @Override
        public void onClick (View view){
            if (view ==  NewClient) {
                Intent intent = new Intent(this, RegisterNewClient.class);
                startActivity(intent);
            }
//            if (view == ForgotPassword) {
//                Intent intent = new Intent(this, .class);
//                startActivity(intent);
//            }
            if (view == Connect) {
                Intent intent = new Intent(this, ChooseCookingBakery.class);
                startActivity(intent);
            }
        }
    }
