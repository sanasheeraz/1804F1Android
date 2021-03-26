package com.example.databasecrudwithlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String emails = email.getText().toString();
               String pass = password.getText().toString();

                if(emails.equals("admin@gmail.com") || pass.equals("admin")){
                    Intent intent =new Intent(Login.this,Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Please Enter Valid Email and Passwaord", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}