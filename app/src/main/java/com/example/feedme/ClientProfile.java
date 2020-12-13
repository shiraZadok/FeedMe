package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//This class  allows the client to see his personal details
public class ClientProfile extends AppCompatActivity implements View.OnClickListener{

    Button UpdateDetails;
    TextView C_Name;
    TextView C_Phone;
    TextView C_Adress;
    TextView C_Password;
    TextView C_Email;

    String id_of_client;


    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        id_of_client= intent.getExtras().getString("id");
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Cients/"+id_of_client);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=(String)snapshot.child("Name").getValue().toString();
                C_Name.setText(""+name);
                String phone=(String)snapshot.child("Phone").getValue().toString();
                C_Phone.setText(""+phone);
                String email=(String)snapshot.child("Email").getValue().toString();
                C_Email.setText(""+email);
                String adress=(String)snapshot.child("Adress").getValue().toString();
                C_Adress.setText(""+adress);
                String password=(String)snapshot.child("Password").getValue().toString();
                C_Password.setText(""+password);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_profile);
        UpdateDetails=(Button)findViewById(R.id.UpdateDetails);
        C_Name=(TextView)findViewById(R.id.B_Name);
        C_Adress=(TextView)findViewById(R.id.B_Adress);
        C_Email=(TextView)findViewById(R.id.B_Email);
        C_Phone=(TextView)findViewById(R.id.B_Phone);
        C_Password=(TextView)findViewById(R.id.B_Password);


        UpdateDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view ==  UpdateDetails) {
            Intent intent = new Intent(this, UpdateClientDetails.class);
            intent.putExtra("id",id_of_client);
            startActivity(intent);
        }
    }
}