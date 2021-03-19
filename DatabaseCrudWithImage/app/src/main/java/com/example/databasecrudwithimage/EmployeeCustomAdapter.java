package com.example.databasecrudwithimage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeCustomAdapter extends RecyclerView.Adapter<EmpListViewHolder> {
        ArrayList<Employee> empList;
        Activity context;
        int resource;

public EmployeeCustomAdapter(@NonNull Activity context, int resource, ArrayList<Employee> empList) {
        this.empList=empList;
        this.context=context;
        this.resource=resource;
        }

        @NonNull
        @Override
        public EmpListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
                View listItem=layoutInflater.inflate(resource,parent,false);
                EmpListViewHolder viewHolder=new EmpListViewHolder(listItem);
                return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull EmpListViewHolder holder, int position) {
                final Employee data=empList.get(position);
                holder.txtName.setText(empList.get(position).name);
                holder.txtEmail.setText(empList.get(position).email);
                holder.txtDept.setText(empList.get(position).dept);
                holder.img.setImageBitmap(Utils.getImage(empList.get(position).img));
//                holder.linearLayout.setOnClickListener(new View.OnClickListener(){
//
//                        @Override
//                        public void onClick(View view) {
//                                Toast.makeText(view.getContext(),"click on item : "+data.getName(),Toast.LENGTH_LONG).show();
//                        }
//                });
        }

        @Override
        public int getItemCount() {
                return empList.size();
        }
}