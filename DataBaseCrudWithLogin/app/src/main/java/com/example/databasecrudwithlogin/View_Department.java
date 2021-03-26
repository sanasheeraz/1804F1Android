package com.example.databasecrudwithlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class View_Department extends AppCompatActivity {

    RecyclerView recycleDepart;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__department);

        recycleDepart=findViewById(R.id.recycleDepartment);
        dbHelper=new DataBaseHelper(View_Department.this);

        Cursor cursor=dbHelper.getAllDept();
        ArrayList<Department> depList=new ArrayList<Department>();
        while(cursor.moveToNext())
        {

            int id=cursor.getInt(cursor.getColumnIndex(DataBaseHelper.T1_Column1));
            String dept=cursor.getString(cursor.getColumnIndex(DataBaseHelper.T1_Column2));

            depList.add(new Department(id,dept));
        }

        DepartmentCutomAdapter adapter=new DepartmentCutomAdapter(View_Department.this,R.layout.department_list_items,depList);
//        lstEmployee.setAdapter(adapter);

        recycleDepart.setHasFixedSize(true);
        recycleDepart.setLayoutManager(new LinearLayoutManager(this));
        recycleDepart.setAdapter(adapter);
    }
}