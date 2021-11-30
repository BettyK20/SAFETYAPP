package com.example.safetyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login2 extends AppCompatActivity implements View.OnClickListener {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
 FirebaseAuth fAuth;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mLoginBtn =  findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText);
        fAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);



        mLoginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainScreen.class));


                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required.");
                    return;

                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required");
                    return;

                }
                if(password.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }
               // progressBar.setVisibility(View.VISIBLE);



           fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()) {
                          Toast.makeText(Login2.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();

                       startActivity(new Intent(getApplicationContext(), MainScreen.class));


                     } else {
                          Toast.makeText(Login2.this, "Error! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      }
                    }
               });

            }

        });
        mCreateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainScreen.class));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}



