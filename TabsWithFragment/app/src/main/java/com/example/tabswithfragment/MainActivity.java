package com.example.tabswithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tbLayout);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        Fragment1 f1=new Fragment1();
                        FragmentTransaction fm=getSupportFragmentManager().beginTransaction();
                        fm.replace(R.id.frameContainer,f1);
                        fm.commit();
                        break;
                    case 1:
                        Fragment2 f2=new Fragment2();
                        FragmentTransaction fm1=getSupportFragmentManager().beginTransaction();
                        fm1.replace(R.id.frameContainer,f2);
                        fm1.commit();
                        break;
                    case 2:
                        Fragment3 f3=new Fragment3();
                        FragmentTransaction fm2=getSupportFragmentManager().beginTransaction();
                        fm2.replace(R.id.frameContainer,f3);
                        fm2.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}