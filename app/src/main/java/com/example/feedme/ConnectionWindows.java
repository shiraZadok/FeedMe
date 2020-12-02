package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ConnectionWindows extends AppCompatActivity implements View.OnClickListener {

    Button Client;
    Button Business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_windows);
        Client=(Button)findViewById(R.id.Client);
        Business=(Button)findViewById(R.id.Business);
        Client.setOnClickListener(this);
        Business.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==Client){
            Intent intent=new Intent(this,CustomerLogin.class);
            startActivity(intent);
        }
//        if(view==Business){
//            Intent intent=new Intent(this,Business.class);
//            startActivity(intent);
//        }
    }
}