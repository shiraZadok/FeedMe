package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class UpdateProduct extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgView;
    private static final int PICK_IMAGE=1;
    Uri imageuri;
    EditText ProductInfo;
    Button UpdateProductButton;
    EditText NumProduct;
    EditText Price;
    TextView Categories;
    Button Kosher;
    Button Vegan;
    Button GlutenFree;
    Button PenutsFree;
    Button Parve;
    Button SugerFree;
    String id_of_Product;
    String id_of_business;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent=getIntent();
        id_of_Product = intent.getExtras().getString("Pid");
        id_of_business = intent.getExtras().getString("Bid");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        imgView=(ImageView)findViewById(R.id.imgView);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,"select picture"),PICK_IMAGE);
            }
        });

        Categories=(TextView)findViewById(R.id.Categories);
        Kosher=(Button)findViewById(R.id.Kosher);
        Vegan=(Button)findViewById(R.id.Vegan);
        GlutenFree=(Button)findViewById(R.id.GlutenFree);
        PenutsFree=(Button)findViewById(R.id.PenutsFree);
        Parve=(Button)findViewById(R.id.Parve);
        SugerFree=(Button)findViewById(R.id.SugerFree);
        ProductInfo=(EditText)findViewById(R.id.ProductInfo);
        NumProduct=(EditText)findViewById(R.id.NumProduct);
        Price=(EditText)findViewById(R.id.Price);
        UpdateProductButton=(Button)findViewById(R.id.UpdateProductButton);

        UpdateProductButton.setOnClickListener(this);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK){
            imageuri=data.getData();
            try{
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                imgView.setImageBitmap(bitmap);
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onClick(View view) {
        rootNode= FirebaseDatabase.getInstance();
        reference=rootNode.getReference();
        System.out.println("referener product $$$$$$$$$"+reference);

        ArrayList<String> category=new ArrayList<String>();
        if(Kosher.getText().toString()!=null){
            category.add("Kosher");
        }
        if(SugerFree.getText().toString()!=null){
            category.add("SugerFree");
        }
        if(GlutenFree.getText().toString()!=null){
            category.add("GlutenFree");
        }
        if(Parve.getText().toString()!=null){
            category.add("Parve");
        }
        if(PenutsFree.getText().toString()!=null){
            category.add("PenutsFree");
        }
        if(Vegan.getText().toString()!=null){
            category.add("Vegan");
        }
   //     Product newproduct=new Product("ggg", "555","100",null ,id_of_business);
       Product newproduct=new Product(ProductInfo.getText().toString(), NumProduct.getText().toString(),Price.getText().toString(),category ,id_of_business);

        newproduct.id=reference.push().getKey();


        if(view==UpdateProductButton){
             reference.child("Products").child(newproduct.id).setValue(newproduct);

            Intent intent=new Intent(this,EditPageBusiness.class);
            intent.putExtra("Bid",id_of_business);
            startActivity(intent);
        }
    }
}