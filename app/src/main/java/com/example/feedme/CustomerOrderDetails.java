package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

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

    public String newname;
    public String newphone;
    public String newemail;
    public String newadress;
    public String newremark;
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

        rootNode= FirebaseDatabase.getInstance();
        reference=rootNode.getReference();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                newname=FullName.getText().toString();
                newphone=PhoneNumber.getText().toString();
                newemail=Email.getText().toString();
                newadress=Adress.getText().toString();
                newremark=Remarks.getText().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onClick(View view) {

        if (view ==  Payment) {
            Order newOrder=new Order(id_of_business_item,Num_Product,newname,newphone,newadress,newremark,newemail);
            String id_of_order=reference.push().getKey();
            newOrder.id_order=id_of_order;


            reference.child("Orders").child(newOrder.id_order).setValue(newOrder);
            Intent intent = new Intent(this, Payment.class);
            startActivity(intent);
        }

    }
}