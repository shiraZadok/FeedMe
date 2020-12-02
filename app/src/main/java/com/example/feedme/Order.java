package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Order extends AppCompatActivity implements View.OnClickListener{

    EditText OrderDetails;
    Button Orderbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        OrderDetails = (EditText)findViewById(R.id.OrderDetails);
        Orderbutton=(Button)findViewById(R.id.Orderbutton);

        Orderbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  Orderbutton) {
            Intent intent = new Intent(this, CustomerOrderDetails.class);
            startActivity(intent);
        }
    }
}