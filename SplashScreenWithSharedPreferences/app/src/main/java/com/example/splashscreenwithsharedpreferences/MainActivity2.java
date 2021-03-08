package com.example.splashscreenwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText edEmail,edPassword;
    Button btnSignIn;
    TextView txtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtname=findViewById(R.id.welcome);
        edEmail=findViewById(R.id.email);
        edPassword=findViewById(R.id.password);
        btnSignIn=findViewById(R.id.signUp);

        final SharedPreferences sharedPreferences=getSharedPreferences("MyData",MODE_PRIVATE);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();

                String userName=sharedPreferences.getString("user Name","");
                String userEmail=sharedPreferences.getString("user Email","");
                String userPassword=sharedPreferences.getString("user Passsword","");

                if(userEmail.equals(email)&&userPassword.equals(password))
                {
                    Toast.makeText(MainActivity2.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    txtname.setText("Welcome "+userName);
                }else
                {
                    Toast.makeText(MainActivity2.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
