package com.example.gmailpattricks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etemail,etpassword;
    Button btnlogin;
    TextView registerlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etemail=(EditText)findViewById(R.id.etemail);
        etpassword=(EditText)findViewById(R.id.etpassword);
        registerlink= (TextView)findViewById(R.id.registerlink);
        btnlogin= (Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLogin();


            }
        });
    }
    public void userLogin(){

       String email= etemail.getText().toString().trim();
       String password= etpassword.getText().toString().trim();

       if (email.isEmpty()){
           Toast.makeText(MainActivity.this, "Enter your Email Please!",Toast.LENGTH_LONG).show();
       }
        if (password.isEmpty()){
            Toast.makeText(MainActivity.this, "Enter the Password Please!",Toast.LENGTH_LONG).show();
        }

        if (email.equals("mutabazi") && password.equals("love")){
            Toast.makeText(MainActivity.this, "login success!",Toast.LENGTH_LONG).show();
            Intent gotoregister= new Intent(MainActivity.this, Registerhere.class);
            startActivity(gotoregister);
        }

        else {

            Toast.makeText(MainActivity.this, "Invalid Credintials",Toast.LENGTH_LONG).show();
        }
    }





}
