package com.example.feedme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//
public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    Button send;
    EditText etTo;
    String sEmail;
    String sPassword;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forgot_password);
            send = findViewById(R.id.Send);
            etTo = findViewById(R.id.editTextTextEmailAddress);

            sEmail = "shira19941@gmail.com";
            sPassword = "shirazadok7";
            send.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        if(v==send){
            Mailer.send("shaharglikman00@gmail.com","shahar!!1998","shira19941@gmail.com","password","555");
        }
    }

//        // attach setOnClickListener to button
}
//public class ForgotPassword extends AppCompatActivity {
//
//    Button send;
//    EditText etTo;
//    String sEmail;
//    String sPassword;
//
//    FirebaseDatabase rootNode;
//    DatabaseReference reference;
//    public static String emailbody;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forgot_password);
//        send = findViewById(R.id.Send);
//        etTo = findViewById(R.id.editTextTextEmailAddress);
//
//        sEmail="shira19941@gmail.com";
//        sPassword="shirazadok7";
//
//        // attach setOnClickListener to button
//        // with Intent object define in it
//        send.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view)
//            {
//                Properties properties=new Properties();
//                properties.put("mail.smtp.auth","true");
//                properties.put("mail.smtp.starttls.enable","true");
//                properties.put("mail.smtp.host","smtp.gmail.com");
//                properties.put("mail.smtp.port","587");
//
//                Session session=Session.getInstance(properties, new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(sEmail,sPassword);
//                    }
//                });
//
//
//                try {
//                    Message message= new MimeMessage(session);
//                    message.setFrom(new InternetAddress(sEmail));
//                    message.setRecipient(Message.RecipientType.TO,new InternetAddress(etTo.getText().toString().trim()));
//                            //InternetAddress.parse(etTo.getText().toString().trim()));
//                    //new InternetAddress(etTo.getText().toString().trim())
//                    message.setSubject("password");
//                    message.setText("Your password is"+"555");
//                    new SendMail().execute(message);
//                } catch (MessagingException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }
//
//    private class SendMail extends AsyncTask<Message,String,String> {
//        private ProgressDialog progressDialog;
//        @Override
//        protected void onPreExecute(){
//            super.onPreExecute();
//            progressDialog=ProgressDialog.show(ForgotPassword.this,"please wait","sending mail",true,false);
//        }
//        @Override
//        protected String doInBackground(Message... messages) {
//            System.out.println("messages[0]"+messages[0]);
//            try {
//                Transport.send(messages[0]);
//                return "Success";
//            } catch (MessagingException e) {
//                e.printStackTrace();
//                return "Error";
//            }
//
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            progressDialog.dismiss();
//            if(s.equals("Success")){
//                AlertDialog.Builder builder=new AlertDialog.Builder(ForgotPassword.this);
//                builder.setCancelable(false);
//                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
//                builder.setMessage("Mail sent");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        etTo.setText("");
//                       // etSubject.setText("");
//                      //  etMessage.setText("");
//
//
//                    }
//                });
//                builder.show();
//            }
//            else{
//                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
//
//
//
//        //Mailer.send("netanelsh0@gmail.com","סיסמא","shira19941@gmail.com","hello or","helooooo meir");

