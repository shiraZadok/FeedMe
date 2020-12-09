package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerOrderDetails extends AppCompatActivity implements View.OnClickListener{

    EditText FullName;
    EditText Adress;
    EditText PhoneNumber;
    EditText Email;
    EditText Remarks;
    Button Payment;
    public String Num_Product;
    public String id_of_business_item;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        Num_Product = intent.getExtras().getString("Num_Product");
        id_of_business_item = intent.getExtras().getString("id_of_business_item");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order_details);
        FullName = (EditText)findViewById(R.id.FullName);
        Adress = (EditText)findViewById(R.id.Adress);
        PhoneNumber = (EditText)findViewById(R.id.PhoneNumber);
        Email = (EditText)findViewById(R.id.Email);
        Remarks = (EditText)findViewById(R.id.Remarks);
        Payment=(Button)findViewById(R.id.Pay);
        Payment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        rootNode= FirebaseDatabase.getInstance();
        reference=rootNode.getReference();
        if (view ==  Payment) {
            Order newOrder=new Order(id_of_business_item,Num_Product);
            String id_of_order=reference.push().getKey();
            newOrder.id_order=id_of_order;
            reference.child("Orders").child(newOrder.id_order).setValue(newOrder);
            Intent intent = new Intent(this, Payment.class);
            startActivity(intent);
        }

    }
}