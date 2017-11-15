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

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button exit = (Button)findViewById(R.id.login_exit);
        final Button login = (Button)findViewById(R.id.loginacc);
        final EditText user = (EditText)findViewById(R.id.login_userinput);
        final EditText pw = (EditText)findViewById(R.id.login_password);

            final SharedPreferences sharedPref = getSharedPreferences("My Data", Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = user.getText().toString();
                String passinput = pw.getText().toString();
                String storeduser = sharedPref.getString("Username",null);
                String storedpass = sharedPref.getString("Password",null);

                if(userinput.equals(storeduser) && passinput.equals(storedpass)){
                    Toast.makeText(login.this,"LOGGED IN",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, logged.class));//indi ya ka love
                    finish();
                } else {
                    Toast.makeText(login.this,"Invalid Login", Toast.LENGTH_SHORT).show();
                }

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, MainActivity.class));
                finish();
            }
        });




    }
}
