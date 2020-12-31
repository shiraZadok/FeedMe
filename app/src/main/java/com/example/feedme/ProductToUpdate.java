package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

//This class represent all the products of business update product of business
public class ProductToUpdate extends AppCompatActivity {

    ListView MyProducts;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String id_business;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button btnUpdate,btnCancel,btnAddNew;
    public String item;
    public String id_of_item;

    public int count = 0;

    public String id_func (String name){
        System.out.println("name= "+name);
        int index_id=name.indexOf("id=");
        index_id+=3;
        String answer="";
        while(name.charAt(index_id)!=',' && index_id<name.length()-1){
            System.out.print(name.charAt(index_id));
            answer+=name.charAt(index_id);
            index_id++;
        }
        System.out.println("mmmmmmmmmm"+answer);
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id_business = intent.getExtras().getString("Bid");
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Products");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_to_update);
        MyProducts =(ListView)findViewById(R.id.MyProducts);

        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        btnCancel= (Button) findViewById(R.id.btnCancel) ;
        btnAddNew= (Button) findViewById(R.id.btnAddNew) ;
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
        ///////////////////////////


        MyProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 item=(String)adapterView.getItemAtPosition(i);//This will give you the same result of viewHolder.LL.setOnClickListener as you are doing
                id_of_item=id_func(item);
                System.out.println("item========"+item);
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intphto =new Intent(getApplicationContext(),UpdateProduct.class);
                intphto.putExtra("Pid",id_of_item);  //id of product
                intphto.putExtra("Bid",id_business);
                startActivity(intphto);
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intphto =new Intent(getApplicationContext(),UpdateProduct.class);
                String id_new_Product=reference.push().getKey();
                intphto.putExtra("Pid",id_new_Product);  //id of product
                intphto.putExtra("Bid",id_business);
                startActivity(intphto);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cleartxt();
            }
        });
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
//    private void Cleartxt(){
//        tID.setText("");
//        tEmail.setText("");
//        tName.setText("");
//        tPassword.setText("");
//        tConfirmPassword.setText("");
//        result.setText("");
//        tID.requestFocus();
//
//    }

//    private void  updateArrayList() {
//        final String ID = tID.getText().toString().trim();
//        final String email = tEmail.getText().toString().trim();
//        final String name = tName.getText().toString().trim();
//        final String password = tPassword.getText().toString().trim();
//        String comfirmpassword = tConfirmPassword.getText().toString().trim();
//        String resulthash = result.getText().toString().trim();
//
//        if (TextUtils.isEmpty(ID)) {
//            tID.setError("Please enter your ID!");
//        } else if (TextUtils.isEmpty(name)) {
//            tName.setError("Please enter your Name!");
//        } else if (TextUtils.isEmpty(email)) {
//            tEmail.setError("Please enter your Email!");
//        } else if (TextUtils.isEmpty(password)) {
//            tPassword.setError("Please enter your Password!");
//        } else if (!password.equals(comfirmpassword)) {
//            tConfirmPassword.setError("Please put the same password");
//        } else {
//
//            Students students = new Students(ID, email, name, password);
//            databaseReference.child("Students").child(ID).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    databaseReference = FirebaseDatabase.getInstance().getReference();
//                    databaseReference.child("Students").child(ID).child("email").setValue(email);
//                    databaseReference.child("Students").child(ID).child("name").setValue(name);
//                    try {
//                        databaseReference.child("Students").child(ID).child("password").setValue(Security.encrypt(password));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//            Toast.makeText(this, "Student is updated", Toast.LENGTH_LONG).show();
//            Cleartxt();
//
//        }
//    }
//}
//



    }


