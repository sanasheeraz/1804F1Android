package com.example.databasecrudwithlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class Dashboard extends AppCompatActivity {

    MaterialButton btnEmpAdd,btnEmpView,btnDeptAdd,btnDeptView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnEmpAdd=findViewById(R.id.empAdd);
        btnEmpView=findViewById(R.id.empView);
        btnDeptAdd=findViewById(R.id.deptAdd);
        btnDeptView=findViewById(R.id.deptView);


        btnEmpAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Employee.class);
                startActivity(intent);
            }
        });

        btnEmpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,View_Employee.class);
                startActivity(intent);
            }
        });

        btnDeptAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnDeptView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,View_Department.class);
                startActivity(intent);
            }
        });
    }
}