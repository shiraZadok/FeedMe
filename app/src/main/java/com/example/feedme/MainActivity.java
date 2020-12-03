package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start=(Button)findViewById(R.id.Start);
        Start.setOnClickListener(this);
        //Toast.makeText( this,"FireBase connection success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (view ==  Start) {
            Intent intent = new Intent(this, ConnectionWindows.class);
            startActivity(intent);
        }
    }
}