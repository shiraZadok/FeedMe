package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BusinessPage extends AppCompatActivity implements View.OnClickListener {

    Button EditPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_page);
        EditPage=(Button)findViewById(R.id.EditPage);
        EditPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  EditPage) {
            Intent intent = new Intent(this, EditPageBusiness.class);
            startActivity(intent);
        }
    }
}