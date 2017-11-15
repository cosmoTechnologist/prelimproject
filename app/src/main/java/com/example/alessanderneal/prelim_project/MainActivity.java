package com.example.alessanderneal.prelim_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SharedPreferences sharedpref = getSharedPreferences("My Data", Context.MODE_PRIVATE);
       final Button login = (Button)findViewById(R.id.mainact_login);
       final Button account = (Button)findViewById(R.id.mainact_account);
       final Button delete = (Button)findViewById(R.id.delete);
       final Button exit = (Button)findViewById(R.id.mainact_exit);
       final String user = sharedpref.getString("Username", null);
       final String pass = sharedpref.getString("Password", null);

        if(user == null && pass == null) {
            login.setEnabled(false);
            account.setEnabled(true);
            delete.setEnabled(false);
        } else {
            login.setEnabled(true);
            delete.setEnabled(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, account.class));
                finish();
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpref.edit().clear().commit();
                do {
                    Toast.makeText(MainActivity.this, "Account Deleted", Toast.LENGTH_LONG).show();
                    login.setEnabled(false);
                    delete.setEnabled(false);
                } while(user == null || pass == null);
            }
        });

    }

}
