package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProductToUpdate extends AppCompatActivity {

    ListView MyProducts;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String id_business;

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id_business = intent.getExtras().getString("Bid");
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Products");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_to_update);
        MyProducts =(ListView)findViewById(R.id.MyProducts);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    String id = (String) postSnapshot.child("id_of_business").getValue().toString();

                    if (id.equals(id_business)) {

                        System.out.println(postSnapshot.getValue());
                    }

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

