package com.example.alessanderneal.prelim_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class account extends AppCompatActivity {
    EditText account_user, account_password;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        final SharedPreferences sharePref = getSharedPreferences("My Data", Context.MODE_PRIVATE);
        final String user = sharePref.getString("Username", null);
        final String pass = sharePref.getString("Password", null);

        final Button append = (Button)findViewById(R.id.account_append);
        Button back = (Button)findViewById(R.id.account_back);
        account_user = (EditText)findViewById(R.id.account_user);
        account_password = (EditText)findViewById(R.id.account_password) ;



        if (sharePref != null ) {
            account_user.setText(user);
            account_password.setText(pass);
        }

        append.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharePref.edit();
                username = account_user.getText().toString();
                password = account_password.getText().toString();

                if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                    Toast.makeText(account.this, "Please enter your account information!", Toast.LENGTH_LONG).show();
                    getIntent();
                } else {

                    editor.putString("Username", username);
                    editor.putString("Password", password);
                    editor.commit();
                    startActivity(new Intent(account.this, MainActivity.class));
                    finish();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account.this, MainActivity.class));
                finish();
            }
        });

    }

}
