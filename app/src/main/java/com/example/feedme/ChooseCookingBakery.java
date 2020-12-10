package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseCookingBakery extends AppCompatActivity implements View.OnClickListener{

    Button HouseCooking;
    Button HouseBakery;
    Button ClientProfile;
    String id_of_client;
   TextView textViewExplain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_client = intent.getExtras().getString("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cooking_bakery);
        HouseCooking=(Button)findViewById(R.id.HouseCooking);
        HouseBakery=(Button)findViewById(R.id.HouseBakery);
        ClientProfile=(Button)findViewById(R.id.ClientProfile);
        textViewExplain=(TextView)findViewById(R.id.textViewExplain);
        HouseCooking.setOnClickListener(this);
        HouseBakery.setOnClickListener(this);
        ClientProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  HouseCooking) {
            Intent intent = new Intent(this, Filters.class);
            startActivity(intent);
        }
        if (view ==  HouseBakery) {
            Intent intent = new Intent(this, Filters.class);
            startActivity(intent);
        }
        if (view ==  ClientProfile) {

            Intent intent = new Intent(this, ClientProfile.class);
            intent.putExtra("id",id_of_client);
            startActivity(intent);
        }

    }
}