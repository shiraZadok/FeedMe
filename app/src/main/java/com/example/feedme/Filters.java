package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

//This class allows the customer to choose the right order for him
public class Filters extends AppCompatActivity implements View.OnClickListener  {

    TextView Place;
    CheckBox Hazafone;
    CheckBox Mercaz;
    CheckBox Hadarom;
    CheckBox Eilat;

    TextView Prices;
    CheckBox until200;
    CheckBox until300;
    CheckBox until400;
    CheckBox until100;
    CheckBox Unlimited;

    TextView textDel;
    CheckBox Delivery;
    CheckBox TakeAway;

    TextView Categories;
    CheckBox Kosher;

    Button Search;
    public String id_of_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_client= intent.getExtras().getString("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        Place=(TextView)findViewById(R.id.place);

        Hazafone=(CheckBox)findViewById(R.id.hazafone);
        Mercaz=(CheckBox)findViewById(R.id.mercaz);
        Hadarom=(CheckBox)findViewById(R.id.hadarom);
        Eilat=(CheckBox)findViewById(R.id.eilat);
        Prices=(TextView)findViewById(R.id.Prices);

        until200=(CheckBox)findViewById(R.id.until200);
        until300=(CheckBox)findViewById(R.id.until300);
        until400=(CheckBox)findViewById(R.id.until400);
        until100=(CheckBox)findViewById(R.id.until100);
        Unlimited=(CheckBox)findViewById(R.id.Unlimited);

        textDel=(TextView)findViewById(R.id.textDel);
        Delivery=(CheckBox)findViewById(R.id. Delivery);
        TakeAway=(CheckBox)findViewById(R.id.TakeAway);

        Categories=(TextView)findViewById(R.id.Categories);
        Kosher=(CheckBox)findViewById(R.id.Kosher);

        Search=(Button)findViewById(R.id.UpdateProductButton);

        Search.setOnClickListener(this);
        Delivery.setOnClickListener(this);
        TakeAway.setOnClickListener(this);


    }
    //String ChooseDel=" ";
    int take=0;
    int del=0;
    String ChoosePlace=" ";
    int ChoosePrice=-1;
    int kosher=0;

    @Override
    public void onClick(View view) {
        if(Delivery.isChecked() ){
            del=1;
        }
        if(TakeAway.isChecked()){
            take=1;
        }
        if(Eilat.isChecked() ){
            ChoosePlace="Eilat";
        }

        if(Hazafone.isChecked() ){
            ChoosePlace="Hazafone";
        }
        if(Mercaz.isChecked() ){
            ChoosePlace="Mercaz";
        }

        if(Hadarom.isChecked() ){
            ChoosePlace="Hadarom";
        }
        if(until100.isChecked() ){
            ChoosePrice=100;
        }
        if(until200.isChecked()){
            ChoosePrice=200;
        }
        if(until300.isChecked() ){
            ChoosePrice=300;
        }
        if(until400.isChecked() ){
            ChoosePrice=400;
        }
        if(Unlimited.isChecked() ){
            ChoosePrice=-1;
        }
        if(Kosher.isChecked() ){
            kosher=1;
        }



        if(view==Search){
            //System.out.println("******************************"+ChooseDel.toString());
          //  System.out.println("******************************"+ChooseCategories.toString());
            System.out.println("******************************"+ChoosePlace.toString());
            //System.out.println("******************************"+ChoosePrice.toString());
            Intent intent=new Intent(this,Options.class);
           // intent.putExtra("ChooseCategories",  ChooseCategories);
            intent.putExtra("takeAway", take);
            intent.putExtra("delivery", del);
            intent.putExtra("ChoosePlace",  ChoosePlace);
            intent.putExtra("ChoosePrice", ChoosePrice);
            intent.putExtra("id", id_of_client);
            intent.putExtra("kosher",kosher);

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