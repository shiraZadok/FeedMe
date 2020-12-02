package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientProfile extends AppCompatActivity implements View.OnClickListener{

    Button UpdateDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_profile);
        UpdateDetails=(Button)findViewById(R.id.UpdateDetails);
        UpdateDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  UpdateDetails) {
            Intent intent = new Intent(this, UpdateClientDetails.class);
            startActivity(intent);
        }
    }
}