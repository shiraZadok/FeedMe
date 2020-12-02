package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerOrderDetails extends AppCompatActivity implements View.OnClickListener{

    EditText FullName;
    EditText Adress;
    EditText PhoneNumber;
    EditText Email;
    EditText Remarks;
    Button Payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order_details);
        FullName = (EditText)findViewById(R.id.FullName);
        Adress = (EditText)findViewById(R.id.Adress);
        PhoneNumber = (EditText)findViewById(R.id.PhoneNumber);
        Email = (EditText)findViewById(R.id.Email);
        Remarks = (EditText)findViewById(R.id.Remarks);
        Payment=(Button)findViewById(R.id.Payment);
        Payment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  Payment) {
            Intent intent = new Intent(this, Payment.class);
            startActivity(intent);
        }

    }
}