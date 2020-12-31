package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;




//This class represent the first page of the app
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start=(Button)findViewById(R.id.Start);
       // Start.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view ==  Start) {
            Intent intent = new Intent(this, ConnectionWindows.class);
            startActivity(intent);
        }
    }


}