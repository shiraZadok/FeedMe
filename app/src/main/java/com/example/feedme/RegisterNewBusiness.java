package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//This class make a new business
public class RegisterNewBusiness extends AppCompatActivity implements View.OnClickListener{

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
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference();
        Business business=new Business(Name.getText().toString(), Password.getText().toString(), Adress.getText().toString(), Email.getText().toString(), Phone.getText().toString());
        business.Bid=reference.push().getKey();
        if (view ==  Create ) {
            reference.child("Business").child(business.Bid).setValue(business);
            Intent intent = new Intent(this,BusinessLogin.class);
            Toast.makeText( this," Your business is registered",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if ( view == Exist) {
            Intent intent = new Intent(this,BusinessLogin.class);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.opt_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.LogOut:
                Intent intent = new Intent(this, ConnectionWindows.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}