package com.example.customlistadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names={"Ibrahim","Ramzan","Talal","Bilal"};
        String[] contacts={"013313131","013313134","013313133","013313135"};
        Integer[] images={R.drawable.download1,R.drawable.download2,R.drawable.download3,R.drawable.download4};

        lst=findViewById(R.id.lstStudents);

        CustomAdapter custom=new CustomAdapter(MainActivity.this,R.layout.activity_my_list_item,names,contacts,images);
        lst.setAdapter(custom);
    }
}