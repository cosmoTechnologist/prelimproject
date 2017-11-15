package com.example.alessanderneal.prelim_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class logged extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        final SharedPreferences sharedpref = getSharedPreferences("My Data", Context.MODE_PRIVATE);

        final Button color = (Button)findViewById(R.id.color);
        final Button logout = (Button)findViewById(R.id.int2_logout);

        final Button addbtn = (Button)findViewById(R.id.Add);
        final Button multbtn = (Button)findViewById(R.id.Multiply);
        final Button dividebtn = (Button)findViewById(R.id.Divide);
        final Button subbtn = (Button)findViewById(R.id.Subtract);

        final EditText op1 = (EditText)findViewById(R.id.op1);
        final EditText op2 = (EditText)findViewById(R.id.op2);
        final TextView total = (TextView)findViewById(R.id.sum);


        total.setEnabled(false);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(op1.getText().toString());
                double num2 = Double.parseDouble(op2.getText().toString());
                double sum = num1 + num2;
                total.setText(Double.toString(sum));
            }
        });

        multbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(op1.getText().toString());
                double num2 = Double.parseDouble(op2.getText().toString());
                double product = num1 * num2;
                total.setText(Double.toString(product));
            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(op1.getText().toString());
                double num2 = Double.parseDouble(op2.getText().toString());
                double difference = num1 - num2;
                total.setText(Double.toString(difference));
            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(op1.getText().toString());
                double num2 = Double.parseDouble(op2.getText().toString());
                double quotient = num1 / num2;
                total.setText(Double.toString(quotient));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(logged.this, MainActivity.class));
                finish();
                Toast.makeText(logged.this, "Log Out Successful", Toast.LENGTH_LONG).show();
            }
        });


        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logged.this, Color.class));
                finish();
            }
        });


    }
}
