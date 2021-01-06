package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//This class allows the business to edit his details
public class EditPageBusiness extends AppCompatActivity implements View.OnClickListener{

    EditText OnUs;
    Button UpdateProducts;
    EditText FullName;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;

    TextView place;
    CheckBox hazafone;
    CheckBox mercaz;
    CheckBox hadarom;
    CheckBox eilat;

    CheckBox delivery;
    CheckBox takeAway;
    public int take;
    public int del;

    Button SaveUpdate;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public String newname;
    public String newphone;
    public String newemail;
    public String newadress;
    public String newpassword;
    String  id_of_business;
    TextView TextViewplace;
    //public String newonus;
    String Chooseplace;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_business = intent.getExtras().getString("Bid");
        take = intent.getExtras().getInt("takeAway");
        del = intent.getExtras().getInt("delivery");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page_business);
        OnUs = (EditText)findViewById(R.id.OnUs);
        FullName = (EditText)findViewById(R.id.FullName);
        Password = (EditText)findViewById(R.id.Password);
        Adress = (EditText)findViewById(R.id.Adress);
        Email = (EditText)findViewById(R.id.Email);
        Phone = (EditText)findViewById(R.id. Phone);
        UpdateProducts=(Button)findViewById(R.id.UpdateProducts);

        hazafone=(CheckBox)findViewById(R.id.hazafone);
        mercaz=(CheckBox)findViewById(R.id.mercaz);
        hadarom=(CheckBox)findViewById(R.id.hadarom);
        eilat=(CheckBox)findViewById(R.id.eilat);
        place=(TextView)findViewById(R.id.place);
        SaveUpdate=(Button)findViewById(R.id.SaveUpdate);

        delivery=(CheckBox)findViewById(R.id.delivery);
        takeAway=(CheckBox)findViewById(R.id.takeAway);

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
                Chooseplace=(String)snapshot.child("BArea").getValue().toString();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        UpdateProducts.setOnClickListener(this);

        SaveUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view ==  SaveUpdate||view ==  UpdateProducts){
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
            if(delivery.isChecked() ){
                System.out.println("del is click");
                del=1;
            }
            if(takeAway.isChecked() ){
                System.out.println("take is click");

                take=1;
            }

            if(hazafone.isChecked()){
                Chooseplace="Hazafone";
            }

            if(eilat.isChecked() ){
                Chooseplace="Eilat";
            }

            if(hazafone.isChecked()){
                Chooseplace="Hazafone";
            }
            if(mercaz.isChecked() ){
                Chooseplace="Mercaz";
            }

            if(hadarom.isChecked()){
                Chooseplace="Hadarom";
            }

        }
        if (view ==  SaveUpdate) {

            Business newbusiness=new Business(newname, newpassword,newadress,Chooseplace, newemail, newphone);
            newbusiness.Bid= id_of_business;;
            reference.setValue(newbusiness);
            //Business business=new Business(Name.getText().toString(), Password.getText().toString(), Adress.getText().toString(), Email.getText().toString(), Phone.getText().toString());
            Intent intent = new Intent(this, BusinessPage.class);
            intent.putExtra("Bid",id_of_business);
            intent.putExtra("delivery",del);
            intent.putExtra("takeAway",take);
            startActivity(intent);
        }
        if (view ==  UpdateProducts) {
            System.out.println("!!!!!!edit =" +take+","+"delivery="+del);

            Intent intent = new Intent(this,ProductToUpdate.class);  //UpdateProduct
            intent.putExtra("Bid",id_of_business);
            intent.putExtra("Chooseplace",Chooseplace);
            intent.putExtra("delivery",del);
            intent.putExtra("takeAway",take);
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