package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Filters extends AppCompatActivity implements View.OnClickListener {

    //Spinner spinner;
    TextView Place;
    Button RamatHagolan;
    Button Hazafone;
    Button Jerusalem;
    Button Hasharon;
    Button TelAviv;
    Button Hadarom;
    Button Eilat;

    TextView Prices;
    Button until200;
    Button until300;
    Button until400;
    Button until100;
    Button Unlimited;

    Button Delivery;
    Button TakeAway;

    TextView Categories;
    Button Kosher;
    Button Vegan;
    Button GlutenFree;
    Button PenutsFree;
    Button Parve;
    Button SugerFree;

    Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        Place=(TextView)findViewById(R.id.Place);

        RamatHagolan=(Button)findViewById(R.id.RamatHagolan);
        Hazafone=(Button)findViewById(R.id.Hazafone);
        Jerusalem=(Button)findViewById(R.id.Jerusalem);
        Hasharon=(Button)findViewById(R.id.Hasharon);
        TelAviv=(Button)findViewById(R.id.TelAviv);
        Hadarom=(Button)findViewById(R.id.Hadarom);
        Eilat=(Button)findViewById(R.id.Eilat);
        Prices=(TextView)findViewById(R.id.Prices);
        //spinner=(Spinner)findViewById(R.id.spinner);

        List<String> listest= new ArrayList<>();
        listest.add("Ramat Hagolan");
        listest.add("Eilat");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listest);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String itemvalue=parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        until200=(Button)findViewById(R.id.until200);
        until300=(Button)findViewById(R.id.until300);
        until400=(Button)findViewById(R.id.until400);
        until100=(Button)findViewById(R.id.until100);
        Unlimited=(Button)findViewById(R.id.Unlimited);

        Delivery=(Button)findViewById(R.id. Delivery);
        TakeAway=(Button)findViewById(R.id.TakeAway);

        Categories=(TextView)findViewById(R.id.Categories);
        Kosher=(Button)findViewById(R.id.Kosher);
        Vegan=(Button)findViewById(R.id.Vegan);
        GlutenFree=(Button)findViewById(R.id.GlutenFree);
        PenutsFree=(Button)findViewById(R.id.PenutsFree);
        Parve=(Button)findViewById(R.id.Parve);
        SugerFree=(Button)findViewById(R.id.SugerFree);

        Search=(Button)findViewById(R.id. Search);

        Search.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==Search){
            Intent intent=new Intent(this,Options.class);
            startActivity(intent);
        }

    }
}