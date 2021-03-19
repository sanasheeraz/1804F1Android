package com.example.databasecrudwithimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewEmployeeActivity extends AppCompatActivity {

    RecyclerView recycleEmployee;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        recycleEmployee=findViewById(R.id.recycleEmployee);
        dbHelper=new DatabaseHelper(ViewEmployeeActivity.this);

        Cursor cursor=dbHelper.getAllEmployees();
        ArrayList<Employee> empList=new ArrayList<Employee>();
        while(cursor.moveToNext())
        {

            int id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.T2_Column1));
            String name=cursor.getString(cursor.getColumnIndex(DatabaseHelper.T2_Column2));
            String email=cursor.getString(cursor.getColumnIndex(DatabaseHelper.T2_Column3));
            String dept=cursor.getString(cursor.getColumnIndex(DatabaseHelper.T1_Column2));
            String password=cursor.getString(cursor.getColumnIndex(DatabaseHelper.T2_Column4));
            byte[] img=cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.T2_Column5));

            empList.add(new Employee(id,name,email,password,img,dept));
        }

        EmployeeCustomAdapter adapter=new EmployeeCustomAdapter(ViewEmployeeActivity.this,R.layout.employee_list_items,empList);
//        lstEmployee.setAdapter(adapter);

        recycleEmployee.setHasFixedSize(true);
        recycleEmployee.setLayoutManager(new LinearLayoutManager(this));
        recycleEmployee.setAdapter(adapter);
    }
}