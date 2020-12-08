package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditPageBusiness extends AppCompatActivity implements View.OnClickListener{

    EditText OnUs;
    Button UpdateProducts;
    Button MyOrders;
    EditText FullName;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;
    TextView textViewPassword;
    TextView textViewAdress;
    TextView textViewPhone;
    TextView textViewEmail;
    TextView textViewName;
    TextView textViewOnUs;
    Button SaveUpdate;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public String newname;
    public String newphone;
    public String newemail;
    public String newadress;
    public String newpassword;
    String  id_of_business;
    //public String newonus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_business = intent.getExtras().getString("Bid");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page_business);
        OnUs = (EditText)findViewById(R.id.OnUs);
        FullName = (EditText)findViewById(R.id.FullName);
        Password = (EditText)findViewById(R.id.Password);
        Adress = (EditText)findViewById(R.id.Adress);
        Email = (EditText)findViewById(R.id.Email);
        Phone = (EditText)findViewById(R.id. Phone);
        textViewPassword = (TextView)findViewById(R.id.textViewPassword);
        UpdateProducts=(Button)findViewById(R.id.UpdateProducts);
        MyOrders=(Button)findViewById(R.id.MyOrders);
        SaveUpdate=(Button)findViewById(R.id.SaveUpdate);
        textViewAdress=(TextView) findViewById(R.id.textViewAdress);
        textViewPhone=(TextView) findViewById(R.id.textViewPhone);
        textViewEmail=(TextView) findViewById(R.id.textViewMail);
        textViewName=(TextView) findViewById(R.id.textViewName);
        textViewOnUs=(TextView) findViewById(R.id.textViewOnUs);

        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Business/"+id_of_business);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                newname=(String)snapshot.child("BName").getValue().toString();
                newphone=(String)snapshot.child("BPhone").getValue().toString();
                newemail=(String)snapshot.child("BEmail").getValue().toString();
                newadress=(String)snapshot.child("BAdress").getValue().toString();
                newpassword=(String)snapshot.child("BPassword").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        UpdateProducts.setOnClickListener(this);
        MyOrders.setOnClickListener(this);
        SaveUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view ==  SaveUpdate) {
            if(!FullName.getText().toString().isEmpty()) {
                newname=FullName.getText().toString();
            }
            if(!Phone.getText().toString().isEmpty()) {
                newphone=Phone.getText().toString();
            }
            if(!Adress.getText().toString().isEmpty()) {
                newadress=Adress.getText().toString();
            }
            if(!Password.getText().toString().isEmpty()) {
                newpassword=Password.getText().toString();
            }
            if(!Email.getText().toString().isEmpty()) {
                newemail=Email.getText().toString();
            }
//            if(!OnUs.getText().toString().isEmpty()) {
//                newonus=OnUs.getText().toString();
//            }
            Business newbusiness=new Business(newname, newpassword,newadress, newemail, newphone);
            newbusiness.Bid= id_of_business;;
            reference.setValue(newbusiness);
            //Business business=new Business(Name.getText().toString(), Password.getText().toString(), Adress.getText().toString(), Email.getText().toString(), Phone.getText().toString());
            Intent intent = new Intent(this, BusinessPage.class);
            intent.putExtra("Bid",id_of_business);
            startActivity(intent);
        }
        if (view ==  UpdateProducts) {
            Intent intent = new Intent(this, UpdateProduct.class);
            intent.putExtra("Bid",id_of_business);
            startActivity(intent);
        }
        if (view ==  MyOrders) {
//            Intent intent = new Intent(this, UpdateProduct.class);
//            intent.putExtra("Bid",id_of_business);
//            startActivity(intent);
        }

    }
}