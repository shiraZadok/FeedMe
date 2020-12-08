package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterNewClient extends AppCompatActivity implements View.OnClickListener {

    EditText Name;
    EditText Password;
    EditText Adress;
    EditText Email;
    EditText Phone;
    Button Create;
    Button Exist;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_client);
        Name = (EditText)findViewById(R.id.Name);
        Password = (EditText)findViewById(R.id.Password);
        Adress = (EditText)findViewById(R.id.Adress);
        Email = (EditText)findViewById(R.id.Email);
        Phone = (EditText)findViewById(R.id.Phone);
        Create=(Button)findViewById(R.id.Update);
        Exist=(Button)findViewById(R.id. Exist);

        Create.setOnClickListener(this);
        Exist.setOnClickListener(this);


        //EditText Name;
        //EditText Password;
       // EditText Adress;
        //EditText Email;
        //EditText Phone;

    }

    @Override
    public void onClick(View view) {
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference();
        System.out.println("referener client $$$$$$$$$"+reference);
        Client client=new Client(Name.getText().toString(), Password.getText().toString(), Adress.getText().toString(), Email.getText().toString(), Phone.getText().toString());
        client.id=reference.push().getKey();

        if (view ==  Create ) {
            reference.child("Cients").child(client.id).setValue(client);
            Intent intent = new Intent(this, CustomerLogin.class);
            startActivity(intent);
        }
        if (view == Exist) {
            Intent intent = new Intent(this, CustomerLogin.class);
            startActivity(intent);
        }

    }
}