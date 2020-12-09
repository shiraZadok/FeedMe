package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Options extends AppCompatActivity {

    List<String> ChooseDel= new ArrayList<>();
    List<String> ChoosePlace= new ArrayList<>();
    List<String> ChoosePrice= new ArrayList<>();
    List<String> ChooseCategories= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        ChooseCategories = Arrays.asList(intent.getExtras().getStringArray("ChooseCategories"));
        ChooseDel = Arrays.asList(intent.getExtras().getStringArray("ChooseDel"));
        ChoosePlace = Arrays.asList(intent.getExtras().getStringArray("ChoosePlace"));
        ChoosePrice = Arrays.asList(intent.getExtras().getStringArray("ChoosePrice"));

        System.out.println("new page");
        System.out.println("******************************"+ChooseDel.toString());
        System.out.println("******************************"+ChooseCategories.toString());
        System.out.println("******************************"+ChoosePlace.toString());
        System.out.println("******************************"+ChoosePrice.toString());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }
}