package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import com.parse.Parse;
import android.text.Html;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ForgetPasswordClient extends AppCompatActivity implements View.OnClickListener{
    Button send;
    EditText etTo;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        send = findViewById(R.id.Send);
        etTo = findViewById(R.id.editTextTextEmailAddress);

        //send.setOnClickListener(this);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("Cients");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                            //from DB
                            String phone = (String) postSnapshot.child("Phone").getValue().toString();
                            String password = (String) postSnapshot.child("Password").getValue().toString();
                            if(phone.equals(etTo.getText().toString())){
                                boolean installed = isAppInstalled("com.whatsapp");
                                String num ="+972";
                                num+=etTo.getText().toString().substring(1);
                                String text = "Hey this is your FeedMe app password:"+password;

                                if(installed)
                                {
                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + text));
                                    startActivity(i);
                                }
                                else{
                                    Toast.makeText(ForgetPasswordClient.this , "whatsapp is not installed!" , Toast.LENGTH_SHORT).show();
                                }

                            }


                        }

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager pk = getPackageManager();
        boolean is_installed;

        try {
            pk.getPackageInfo(s, pk.GET_ACTIVITIES);
            is_installed = true;

        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }

        return is_installed;
    }

    @Override
    public void onClick(View v) {

    }
}