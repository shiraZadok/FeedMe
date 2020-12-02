package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditPageBusiness extends AppCompatActivity implements View.OnClickListener{

    EditText OnUs;
    Button UpdateProducts;
    Button UpdateGallery;
    Button UpdateDetailsBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page_business);
        OnUs = (EditText)findViewById(R.id.OnUs);
        UpdateProducts=(Button)findViewById(R.id.UpdateProducts);
        UpdateGallery=(Button)findViewById(R.id.UpdateGallery);
        UpdateDetailsBusiness=(Button)findViewById(R.id.UpdateDetailsBusiness);

        UpdateProducts.setOnClickListener(this);
        UpdateGallery.setOnClickListener(this);
        UpdateDetailsBusiness.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
//        if (view ==  UpdateProducts) {
//            Intent intent = new Intent(this, .class);
//            startActivity(intent);
//        }
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