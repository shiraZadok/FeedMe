package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateClientDetails extends AppCompatActivity  implements View.OnClickListener{

    EditText Name;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_client_details);
        Name = (EditText)findViewById(R.id.Name);
        Password = (EditText)findViewById(R.id.Password);
        Adress = (EditText)findViewById(R.id.Adress);
        Email = (EditText)findViewById(R.id.Email);
        Phone = (EditText)findViewById(R.id.Phone);
        Update=(Button)findViewById(R.id.Update);


        Update.setOnClickListener(this);


        //EditText Name;
        //EditText Password;
        // EditText Adress;
        //EditText Email;
        //EditText Phone;
    }

    @Override
    public void onClick(View view) {
        if (view ==  Update) {
            Intent intent = new Intent(this, ChooseCookingBakery.class);
            startActivity(intent);
        }
    }
}