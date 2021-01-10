package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
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

public class ForgotPassword extends AppCompatActivity {

    Button send;
    EditText editTextTextEmailAddress;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    public static String emailbody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        send = findViewById(R.id.Send);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);


        // attach setOnClickListener to button
        // with Intent object define in it
        send.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String emailsend = editTextTextEmailAddress.getText().toString();
                System.out.println("emailsenddddddddd"+emailsend);
                String emailsubject ="Your password" ;
                emailbody ="password ???";
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("Cients");
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                            //from DB
                            String email = (String) postSnapshot.child("Email").getValue().toString();
                            String password = (String) postSnapshot.child("Password").getValue().toString();
                            if(email.equals(emailsend)){
                                System.out.println("email"+email);
                                System.out.println("password"+password);

                                emailbody=password;
                            }
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                    // define Intent object
                // with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);
                System.out.println("emailbody"+emailbody);
                // add three fiels to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] { emailsend });
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser
                // as Email client using createChooser function
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
    }
}



        //Mailer.send("netanelsh0@gmail.com","סיסמא","shira19941@gmail.com","hello or","helooooo meir");
