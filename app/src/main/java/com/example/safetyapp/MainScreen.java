package com.example.safetyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainScreen extends AppCompatActivity {
    EditText mStartingPoint,mDestination;
    Button mCheckSafetyScoreCard;
    TextView mCreateBtn;
    FirebaseAuth fAuth;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mStartingPoint = findViewById(R.id.startingPoint);
        mDestination = findViewById(R.id.Destination);
        mCheckSafetyScoreCard =  findViewById(R.id.checksafetyscorecardbtn);
        mCreateBtn = findViewById(R.id.createText);
        fAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);

//        mCheckSafetyScoreCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
//            }
//        }
//        );
    }

    public void MyProfile(View view) {
    }

    public void CheckSafetyScoreCard(View view) {
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(i);
    }
}