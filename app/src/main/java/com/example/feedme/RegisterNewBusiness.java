package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterNewBusiness extends AppCompatActivity implements View.OnClickListener{

    EditText Name;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;
    Button Create;
    Button Exist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_business);
        Name = (EditText)findViewById(R.id.Name);
        Password = (EditText)findViewById(R.id.Password);
        Adress = (EditText)findViewById(R.id.Adress);
        Email = (EditText)findViewById(R.id.Email);
        Phone = (EditText)findViewById(R.id.Phone);
        Create=(Button)findViewById(R.id.Update);
        Exist=(Button)findViewById(R.id. Exist);

        Create.setOnClickListener(this);
        Exist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  Create || view == Exist) {
            Intent intent = new Intent(this,BusinessLogin.class);
            startActivity(intent);
        }
     
    }
}