package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//This class represent to business all his orders
public class BusinessOrders extends AppCompatActivity implements View.OnClickListener {
    ListView MyOrders;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    String id_business;
    Button Erase;
    public String item;
    public String  id_order;
    public int take;
    public int del;

    public String id_func (String name,String search){
        System.out.println("name= "+name);
        int index_id=name.indexOf(search);
        index_id+=search.length()+1;
        String answer="";
        while(index_id<=name.length()-1 &&name.charAt(index_id)!='\n'){
            System.out.print(name.charAt(index_id));
            answer+=name.charAt(index_id);
            index_id++;
        }
        System.out.println("id of search ????="+answer);
        return answer;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id_business = intent.getExtras().getString("Bid");
        take = intent.getExtras().getInt("takeAway");
        del = intent.getExtras().getInt("delivery");
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Orders");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_orders);
        MyOrders =(ListView)findViewById(R.id.MyOrders);
        Erase =(Button)findViewById(R.id.Erase);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        MyOrders.setAdapter(arrayAdapter);
        Erase.setOnClickListener(this);

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
        MyOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item=(String)adapterView.getItemAtPosition(i);//This will give you the same result of viewHolder.LL.setOnClickListener as you are doing
                id_order=id_func(item,"id order=");
            }

        });



    }

    @Override
    public void onClick(View v) {

        if (v==Erase){
            Intent intent = new Intent(this, BusinessPage.class);
            intent.putExtra("Bid", id_business);
            intent.putExtra("takeAway", take);
            intent.putExtra("delivery", del);


            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setTitle("Watch out!");
            dialog.setMessage("Are you sure you want to delete this order?");
            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getApplicationContext(),"you have pressed tes",Toast.LENGTH_SHORT).show();
                    reference = rootNode.getReference("Orders").child(id_order);
                    reference.removeValue();
                    startActivity(intent);

                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            dialog.show();




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