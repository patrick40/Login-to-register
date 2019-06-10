package com.example.gmailpattricks;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registerhere extends AppCompatActivity{
    private FirebaseAuth mAuth;
    EditText etmail,etpass;
    Button btnregister;
    TextView loginlink;
    public void userRegister(){

        String email= etmail.getText().toString().trim();
        String password= etpass.getText().toString().trim();

        if (email.isEmpty()){
            Toast.makeText(Registerhere.this, "Enter your Email Please!",Toast.LENGTH_LONG).show();
        }
        if (password.isEmpty()){
            Toast.makeText(Registerhere.this, "Enter the Password Please!",Toast.LENGTH_LONG).show();
        }

        else {

            // we are going to regisrter our user here

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(Registerhere.this, "User successfully registered.",Toast.LENGTH_LONG).show();

                    }
                }
            });






        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerhere);
        mAuth = FirebaseAuth.getInstance();
        etmail=(EditText)findViewById(R.id.etmail);
        etpass=(EditText)findViewById(R.id.etpass);
        loginlink= (TextView)findViewById(R.id.btnlogin);
        btnregister= (Button)findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });





    }
}
