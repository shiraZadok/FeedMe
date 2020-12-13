package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//This class allows you to select a client / business connection
public class ConnectionWindows extends AppCompatActivity implements View.OnClickListener {

    Button Client;
    Button BusinessOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_windows);
        Client=(Button)findViewById(R.id.Client);
        BusinessOwner=(Button)findViewById(R.id.BusinessOwner);
        Client.setOnClickListener(this);
        BusinessOwner.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==Client){
            Intent intent=new Intent(this,CustomerLogin.class);
            startActivity(intent);
        }
        if(view==BusinessOwner){
            Intent intent=new Intent(this,BusinessLogin.class);
            startActivity(intent);
        }
    }
}