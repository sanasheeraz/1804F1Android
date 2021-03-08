package com.example.menuitemsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.net.URI;

public class MainActivity2 extends AppCompatActivity {

    EditText edNumber;
    ImageButton btnCall,btnMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edNumber=findViewById(R.id.txtNumber);
        btnCall=findViewById(R.id.btnCall);
        btnMsg=findViewById(R.id.btnMsg);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=edNumber.getText().toString();

                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+num));
                startActivity(intent);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=edNumber.getText().toString();

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.fromParts("sms",num,null));
                startActivity(intent);
            }
        });
    }



}
