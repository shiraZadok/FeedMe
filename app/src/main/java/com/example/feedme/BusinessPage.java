package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//This class represent the profile of the business
public class BusinessPage extends AppCompatActivity implements View.OnClickListener {

    Button EditPage;
    Button MyOrders;


    TextView B_Name;
    TextView B_Phone;
    TextView B_Adress;
    TextView B_Password;
    TextView B_Email;
    String  id_of_business;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public int take;
    public int del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_business = intent.getExtras().getString("Bid");
        take = intent.getExtras().getInt("takeAway");
        del = intent.getExtras().getInt("delivery");


        rootNode= FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Business/"+id_of_business);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=(String)snapshot.child("BName").getValue().toString();
                B_Name.setText(""+name);
                String phone=(String)snapshot.child("BPhone").getValue().toString();
                B_Phone.setText(""+phone);
                String email=(String)snapshot.child("BEmail").getValue().toString();
                B_Email.setText(""+email);
                String adress=(String)snapshot.child("BAdress").getValue().toString();
                B_Adress.setText(""+adress);
                String password=(String)snapshot.child("BPassword").getValue().toString();
                B_Password.setText(""+password);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_page);
        EditPage=(Button)findViewById(R.id.EditPage);
        MyOrders=(Button)findViewById(R.id.myOrders);
        EditPage.setOnClickListener(this);
        B_Name=(TextView)findViewById(R.id.B_Name);
        B_Adress=(TextView)findViewById(R.id.B_Adress);
        B_Email=(TextView)findViewById(R.id.B_Email);
        B_Phone=(TextView)findViewById(R.id.B_Phone);
        B_Password=(TextView)findViewById(R.id.B_Password);

        MyOrders.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  EditPage) {
            Intent intent = new Intent(this, EditPageBusiness.class);
            intent.putExtra("Bid",id_of_business);
            intent.putExtra("delivery",del);
            intent.putExtra("takeAway",take);
            startActivity(intent);
        }
        if (view ==  MyOrders) {
            Intent intent = new Intent(this, BusinessOrders.class);
            intent.putExtra("Bid",id_of_business);

            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.opt_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.LogOut:
                Intent intent = new Intent(this, ConnectionWindows.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}