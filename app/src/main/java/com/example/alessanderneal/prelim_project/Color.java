package com.example.alessanderneal.prelim_project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Color extends AppCompatActivity {
   Button redbtn, greenbtn, bluebtn, backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    redbtn = (Button)findViewById(R.id.Red);
    greenbtn = (Button)findViewById(R.id.Green);
    bluebtn = (Button)findViewById(R.id.Blue);
    backbtn = (Button)findViewById(R.id.int_back);


        redbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setTitle("Red");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Red)));

            }
        });
//
        greenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setTitle("Green");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Green)));
            }
        });
//
        bluebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setTitle("Blue");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Blue)));
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Color.this, logged.class));
                finish();
            }
        });



    }


}


