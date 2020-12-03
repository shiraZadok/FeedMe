package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditPageBusiness extends AppCompatActivity implements View.OnClickListener{

    EditText OnUs;
    Button UpdateProducts;
    Button UpdateGallery;
    EditText FullName;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;
    TextView textViewPassword;
    Button SaveUpdate;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        UpdateGallery=(Button)findViewById(R.id.UpdateGallery);
        SaveUpdate=(Button)findViewById(R.id.SaveUpdate);

        UpdateProducts.setOnClickListener(this);
        UpdateGallery.setOnClickListener(this);
        SaveUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference();
        if (view ==  SaveUpdate) {
            //Business business=new Business(Name.getText().toString(), Password.getText().toString(), Adress.getText().toString(), Email.getText().toString(), Phone.getText().toString());
            //Intent intent = new Intent(this, .class);
            //startActivity(intent);
        }
//        if (view ==  UpdateGallery) {
//            Intent intent = new Intent(this, t.class);
//            startActivity(intent);
//        }
//        if (view ==  UpdateDetailsBusiness) {
//            Intent intent = new Intent(this, .class);
//            startActivity(intent);
//        }
    }
}