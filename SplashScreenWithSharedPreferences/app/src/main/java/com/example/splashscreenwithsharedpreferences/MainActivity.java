package com.example.splashscreenwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName,edEmail,edPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.name);
        edEmail=findViewById(R.id.email);
        edPassword=findViewById(R.id.password);
        btnSignUp=findViewById(R.id.signUp);

        final SharedPreferences sharedPreferences=getSharedPreferences("MyData",MODE_PRIVATE);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("user Name",name);
                editor.putString("user Email",email);
                editor.putString("user Passsword",password);

                editor.commit();
                Toast.makeText(MainActivity.this, "Shared Preferences Created", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });

    }
}
