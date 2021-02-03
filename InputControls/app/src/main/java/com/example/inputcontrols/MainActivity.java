package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup rdGroup;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnSubmit);
        rdGroup=findViewById(R.id.rdGender);
        sp=findViewById(R.id.spCity);

        List<String> cities=new ArrayList<String>();
        cities.add("Islamabad");
        cities.add("Karachi");
        cities.add("Quetta");
        cities.add("Peshawar");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,cities);
        sp.setAdapter(dataAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rid=rdGroup.getCheckedRadioButtonId();
                RadioButton rdbutton=findViewById(rid);



                Toast.makeText(MainActivity.this,"Value : "+rdbutton.getText().toString()+" City : "+String.valueOf(sp.getSelectedItem()),Toast.LENGTH_LONG).show();
            }
        });
    }
}