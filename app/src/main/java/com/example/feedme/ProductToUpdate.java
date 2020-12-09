package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
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
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

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
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        MyProducts.setAdapter(arrayAdapter);
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String id = (String) snapshot.child("id_of_business").getValue().toString();
                String value =(String) snapshot.getValue(Product.class).toString();
                //String value = (String) snapshot.child("Price").getValue().toString();

                if (id.equals(id_business)) {
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();
                    System.out.println(snapshot.getValue());
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
//                    String id = (String) postSnapshot.child("id_of_business").getValue().toString();
//
//                    if (id.equals(id_business)) {
//                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//                        arrayList.add(id);
//                        arrayAdapter.notifyDataSetChanged();
//
//                    }
//
//                }
//
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
}

