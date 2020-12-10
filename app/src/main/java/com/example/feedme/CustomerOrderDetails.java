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

    public String oldname;
    public String oldphone;
    public String oldemail;
    public String oldadress;
    public String oldremark;
    public String id_of_client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        Num_Product = intent.getExtras().getString("Num_Product");
        id_of_business_item = intent.getExtras().getString("id_of_business_item");
        id_of_client = intent.getExtras().getString("id_of_client");

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
        reference=rootNode.getReference("Cients/"+id_of_client);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                oldname=(String)snapshot.child("Name").getValue().toString();
                oldphone=(String)snapshot.child("Phone").getValue().toString();
                oldemail=(String)snapshot.child("Email").getValue().toString();
                oldadress=(String)snapshot.child("Adress").getValue().toString();
                //oldremark=(String)snapshot.child("").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }



    @Override
    public void onClick(View view) {
        reference=rootNode.getReference("Orders/");

        if (view ==  Payment) {
            if(!FullName.getText().toString().isEmpty()) {
                oldname=FullName.getText().toString();
            }
            if(!PhoneNumber.getText().toString().isEmpty()) {
                oldphone=PhoneNumber.getText().toString();
            }
            if(!Adress.getText().toString().isEmpty()) {
                oldadress=Adress.getText().toString();
            }

            if(!Email.getText().toString().isEmpty()) {
                oldemail=Email.getText().toString();
            }
            Order newOrder=new Order(id_of_business_item,Num_Product,oldname,oldphone,oldadress,oldemail);
            String id_of_order=reference.push().getKey();
            newOrder.id_order=id_of_order;


            reference.child(newOrder.id_order).setValue(newOrder);
            Intent intent = new Intent(this, Payment.class);
            startActivity(intent);
        }

    }
}