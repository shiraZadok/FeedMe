package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

//This class shows the customer the right products for him according to his choices on the page - Filter
public class Options extends AppCompatActivity  implements View.OnClickListener{

    ListView ViewP;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseStorage storage;  //31
    private StorageReference storageReference;  //31
    Button Pay;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    public String item;
    public String id_of_business_item;
    public String num_item;
    public String id_of_client;

    public int take;
    public int del;


    ArrayList<String> ChooseDel= new ArrayList<>();
    String ChoosePlace;
    int ChoosePrice;
    ArrayList<String> ChooseCategories= new ArrayList<>();



    public String id_func (String name,String search){
        System.out.println("name= "+name);
        int index_id=name.indexOf(search);
        index_id+=search.length();
        String answer="";
        while(name.charAt(index_id)!=',' && index_id<name.length()-1 && name.charAt(index_id)!=' '){
            System.out.print(name.charAt(index_id));
            answer+=name.charAt(index_id);
            index_id++;
        }
        System.out.println("id of busniess item is ????="+answer);
        return answer;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        ChooseCategories =intent.getExtras().getStringArrayList(("ChooseCategories"));
        //ChooseDel = intent.getExtras().getStringArrayList(("ChooseDel"));
        del=intent.getExtras().getInt("delivery");
        take=intent.getExtras().getInt("takeAway");
        ChoosePlace = intent.getExtras().getString("ChoosePlace");
        ChoosePrice = intent.getExtras().getInt("ChoosePrice");
        id_of_client= intent.getExtras().getString("id");


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Products");


        storage= FirebaseStorage.getInstance();  //31
        storageReference=storage.getReference();  //31



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Pay= (Button) findViewById(R.id.Pay) ;

        System.out.println("new page");
//        System.out.println("******************************"+ ChooseDel.toString());
        System.out.println("******************************"+ChooseCategories.toString());
        System.out.println("******************************"+ChoosePlace.toString());
        //System.out.println("******************************"+ChoosePrice.toString());
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        ViewP =(ListView)findViewById(R.id.ViewP);
        ViewP.setAdapter(arrayAdapter);
        Pay.setOnClickListener(this);


        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value =(String) snapshot.getValue(Product.class).toString();
                //StorageReference riversRef = storageReference.child("images/"+id_func(value,"id=")); //31
                //String value2= riversRef.getDownloadUrl().toString();//31
                //System.out.println("value2"+value2);
                String price =  (String) snapshot.child("Price").getValue().toString();
                String area =  (String) snapshot.child("Area").getValue().toString();

                String temp=(String) snapshot.child("takeAway").getValue().toString();
                String temp2=(String) snapshot.child("delivery").getValue().toString();
                int takeproduct=Integer.parseInt(temp);
                int delproduct=Integer.parseInt(temp2);

                int p=Integer.parseInt(price);
                //System.out.println("ChoosePrice"+ChoosePrice+"ChoosePlace"+ChoosePlace);
                boolean flag=false;
                if(take==1 && takeproduct==1){ flag=true;}
                if(del==1&& delproduct==1){ flag=true;}
                if(take==0 && del==0){flag=true;}

                if(ChoosePrice==-1) {
                    if(ChoosePlace.equals(" ") &&flag==true) {
                        arrayList.add(value);
                    }
                    else
                    if(area.equals(ChoosePlace)&&flag==true){
                        arrayList.add(value);
                    }
                }

                if(p<=ChoosePrice ){
                    if(ChoosePlace.equals(" ")&&flag==true) {
                        arrayList.add(value);
                    }
                    else
                    if(area.equals(ChoosePlace)&&flag==true){
                        arrayList.add(value);
                    }
                }

//                String C_Kosher = (String) snapshot.child("category").child("Kosher").getValue().toString();
//                String C_SugerFree = (String) snapshot.child("category").child("SugerFree").getValue().toString();
//                String C_GlutenFree = (String) snapshot.child("category").child("GlutenFree").getValue().toString();
//                String C_Parve = (String) snapshot.child("category").child("Parve").getValue().toString();
//                String C_PenutsFree = (String) snapshot.child("category").child("PenutsFree").getValue().toString();
//                String C_Vegan = (String) snapshot.child("category").child("Vegan").getValue().toString();
                //if

                //arrayList.add(value2); //31
                arrayAdapter.notifyDataSetChanged();

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

        ViewP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item=(String)adapterView.getItemAtPosition(i);//This will give you the same result of viewHolder.LL.setOnClickListener as you are doing
                id_of_business_item=id_func(item,"id_of_business=");
                num_item=id_func(item,"Num of Product=");
                System.out.println("item========"+item);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v==Pay){
            Intent intent= new Intent(this,CustomerOrderDetails.class);
            intent.putExtra("Num_Product",num_item);
            intent.putExtra("id_of_business_item",id_of_business_item);
            intent.putExtra("id_of_client",id_of_client);
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