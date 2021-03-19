package com.example.databasecrudwithimage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    private EditText edName,edEmail,edPassword,edImage;
    private Spinner spDept;
    private Button btnAdd,btnUpload,btnView;
    private DatabaseHelper dbHelper;
    private Uri ImageUri;
    private byte[] imgArray;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        edName=findViewById(R.id.txtName);
        edEmail=findViewById(R.id.txtEmail);
        edPassword=findViewById(R.id.txtPassword);
        spDept=findViewById(R.id.txtDept);
        imgView=findViewById(R.id.txtImage);

        btnAdd=findViewById(R.id.btnAdd);
        btnUpload=findViewById(R.id.uploadImg);
        btnView=findViewById(R.id.btnView);

        ArrayList<String> lstDeptName=new ArrayList<String>();
        ArrayList<Integer> lstDeptId=new ArrayList<Integer>();

        dbHelper=new DatabaseHelper(EmployeeActivity.this);

        Cursor cursor=dbHelper.getAllDept();
        while(cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.T1_Column1));
            String name=cursor.getString(cursor.getColumnIndex(DatabaseHelper.T1_Column2));
            lstDeptName.add(name);
            lstDeptId.add(id);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(EmployeeActivity.this,R.layout.support_simple_spinner_dropdown_item,lstDeptName);
        spDept.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String dept=spDept.getSelectedItem().toString();
                int id= lstDeptName.indexOf(dept);
                int deptId=lstDeptId.get(id);

                try {
                    InputStream input= getContentResolver().openInputStream(ImageUri);
                    imgArray=Utils.getBytes(input);

                    boolean result=dbHelper.insertEmployee(name,email,password,imgArray,deptId);
                    if(result)
                    {
                        Toast.makeText(EmployeeActivity.this, "EmployeeAdded Succesfully", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(EmployeeActivity.this, "Employee Not Added", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),200);
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(EmployeeActivity.this,ViewEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200)
        {
            if(resultCode==RESULT_OK)
            {
                ImageUri=data.getData();
                try {
                    imgView.setImageBitmap(Utils.getImage(Utils.getBytes(getContentResolver().openInputStream(ImageUri))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}