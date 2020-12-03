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

public class ClientProfile extends AppCompatActivity implements View.OnClickListener{

    Button UpdateDetails;
    TextView MyDetail;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Clients");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String answer=(String)snapshot.getValue();
                MyDetail.setText(answer);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_profile);
        UpdateDetails=(Button)findViewById(R.id.UpdateDetails);
        MyDetail=(TextView)findViewById(R.id.MyDetail);

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