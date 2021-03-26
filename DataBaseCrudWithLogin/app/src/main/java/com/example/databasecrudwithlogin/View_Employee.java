package com.example.databasecrudwithlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class View_Employee extends AppCompatActivity {

    RecyclerView recycleEmployee;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__employee);

        recycleEmployee=findViewById(R.id.recycleEmployee);
        dbHelper=new DataBaseHelper(View_Employee.this);

        Cursor cursor=dbHelper.getAllEmployees();
        ArrayList<EmployeeClass> empList=new ArrayList<EmployeeClass>();
        while(cursor.moveToNext())
        {

            int id=cursor.getInt(cursor.getColumnIndex(DataBaseHelper.T2_Column1));
            String name=cursor.getString(cursor.getColumnIndex(DataBaseHelper.T2_Column2));
            String email=cursor.getString(cursor.getColumnIndex(DataBaseHelper.T2_Column3));
            String dept=cursor.getString(cursor.getColumnIndex(DataBaseHelper.T1_Column2));
            String password=cursor.getString(cursor.getColumnIndex(DataBaseHelper.T2_Column4));
            byte[] img=cursor.getBlob(cursor.getColumnIndex(DataBaseHelper.T2_Column5));

            empList.add(new EmployeeClass(id,name,email,password,img,dept));
        }

        EmployeeCustomAdapter adapter=new EmployeeCustomAdapter(View_Employee.this,R.layout.employee_list_items,empList);
//        lstEmployee.setAdapter(adapter);

        recycleEmployee.setHasFixedSize(true);
        recycleEmployee.setLayoutManager(new LinearLayoutManager(this));
        recycleEmployee.setAdapter(adapter);
    }
}