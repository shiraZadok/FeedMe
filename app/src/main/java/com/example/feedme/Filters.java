package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filters extends AppCompatActivity implements View.OnClickListener  {

    TextView Place;
    CheckBox RamatHagolan;
    CheckBox Hazafone;
    CheckBox Jerusalem;
    CheckBox Hasharon;
    CheckBox TelAviv;
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
    CheckBox Vegan;
    CheckBox GlutenFree;
    CheckBox PenutsFree;
    CheckBox Parve;
    CheckBox SugerFree;

    Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        Place=(TextView)findViewById(R.id.Place);

        RamatHagolan=(CheckBox)findViewById(R.id.RamatHagolan);
        Hazafone=(CheckBox)findViewById(R.id.Hazafone);
        Jerusalem=(CheckBox)findViewById(R.id.Jerusalem);
        Hasharon=(CheckBox)findViewById(R.id.Hasharon);
        TelAviv=(CheckBox)findViewById(R.id.TelAviv);
        Hadarom=(CheckBox)findViewById(R.id.Hadarom);
        Eilat=(CheckBox)findViewById(R.id.Eilat);
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
        Vegan=(CheckBox)findViewById(R.id.Vegan);
        GlutenFree=(CheckBox)findViewById(R.id.GlutenFree);
        PenutsFree=(CheckBox)findViewById(R.id.PenutsFree);
        Parve=(CheckBox)findViewById(R.id.Parve);
        SugerFree=(CheckBox)findViewById(R.id.SugerFree);

        Search=(Button)findViewById(R.id.UpdateProductButton);

        Search.setOnClickListener(this);
        Delivery.setOnClickListener(this);
        TakeAway.setOnClickListener(this);


    }
    ArrayList<String> ChooseDel= new ArrayList<>();
    ArrayList<String> ChoosePlace= new ArrayList<>();
    ArrayList<String> ChoosePrice= new ArrayList<>();
    ArrayList<String> ChooseCategories= new ArrayList<>();

    @Override
    public void onClick(View view) {
        if(Delivery.isChecked() && !ChooseDel.contains("Delivery")){
            ChooseDel.add("Delivery");
        }
        if(TakeAway.isChecked()&& !ChooseDel.contains("TakeAway")){
            ChooseDel.add("TakeAway");
        }
        if(Eilat.isChecked() && !ChoosePlace.contains("Eilat")){
            ChoosePlace.add("Eilat");
        }
        if(RamatHagolan.isChecked() && !ChoosePlace.contains("RamatHagolan")){
            ChoosePlace.add("RamatHagolan");
        }
        if(Hazafone.isChecked() && !ChoosePlace.contains("Hazafone")){
            ChoosePlace.add("Hazafone");
        }
        if(TelAviv.isChecked() && !ChoosePlace.contains("TelAviv")){
            ChoosePlace.add("TelAviv");
        }
        if(Jerusalem.isChecked() && !ChoosePlace.contains("Jerusalem")){
            ChoosePlace.add("Jerusalem");
        }
        if(Hasharon.isChecked() && !ChoosePlace.contains("Hasharon")){
            ChoosePlace.add("Hasharon");
        }
        if(Hadarom.isChecked() && !ChoosePlace.contains("Hadarom")){
            ChoosePlace.add("Hadarom");
        }
        if(until100.isChecked() && ! ChoosePrice.contains("until100")){
            ChoosePrice.add("until100");
        }
        if(until200.isChecked() && ! ChoosePrice.contains("until200")){
            ChoosePrice.add("until200");
        }
        if(until300.isChecked() && ! ChoosePrice.contains("until300")){
            ChoosePrice.add("until300");
        }
        if(until400.isChecked() && ! ChoosePrice.contains("until400")){
            ChoosePrice.add("until400");
        }
        if(Unlimited.isChecked() && ! ChoosePrice.contains("Unlimited")){
            ChoosePrice.add("Unlimited");
        }
        if(Kosher.isChecked() && !ChooseCategories.contains("Kosher")){
            ChooseCategories.add("Kosher");
        }
        if(Vegan.isChecked() && !ChooseCategories.contains("Vegan")){
            ChooseCategories.add("Vegan");
        }
        if(GlutenFree.isChecked() && !ChooseCategories.contains("GlutenFree")){
            ChooseCategories.add("GlutenFree");
        }
        if(PenutsFree.isChecked() && !ChooseCategories.contains("PenutsFree")){
            ChooseCategories.add("PenutsFree");
        }
        if(Parve.isChecked() && !ChooseCategories.contains("Parve")){
            ChooseCategories.add("Parve");
        }
        if(SugerFree.isChecked() && !ChooseCategories.contains("SugerFree")){
            ChooseCategories.add("SugerFree");
        }

        if(view==Search){
            System.out.println("******************************"+ChooseDel.toString());
            System.out.println("******************************"+ChooseCategories.toString());
            System.out.println("******************************"+ChoosePlace.toString());
            System.out.println("******************************"+ChoosePrice.toString());
            Intent intent=new Intent(this,Options.class);
            intent.putExtra("ChooseCategories",  ChooseCategories);
            intent.putExtra("ChooseDel", ChooseDel);
            intent.putExtra("ChoosePlace",  ChoosePlace);
            intent.putExtra("ChoosePrice", ChoosePrice);
            startActivity(intent);
        }
    }
}