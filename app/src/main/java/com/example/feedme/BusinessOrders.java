package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BusinessOrders extends AppCompatActivity {
    ListView MyOrders;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    String id_business;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id_business = intent.getExtras().getString("Bid");
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Orders");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_orders);
        MyOrders =(ListView)findViewById(R.id.MyOrders);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        MyOrders.setAdapter(arrayAdapter);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value =(String) snapshot.getValue(Order.class).toString();
                String id = (String) snapshot.child("id_of_business_item").getValue().toString();

                System.out.println("XXXXXXXX");
                System.out.println(id_business);
                System.out.println(id);

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
    }
}