package com.example.databasecrudwithlogin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DepartmentCutomAdapter extends RecyclerView.Adapter<DepartmentListViewHolder> {
    ArrayList<Department> depList;
    Activity context;
    int resource;

    public DepartmentCutomAdapter(@NonNull Activity context, int resource, ArrayList<Department> depList) {
        this.depList=depList;
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public DepartmentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem=layoutInflater.inflate(resource,parent,false);
        DepartmentListViewHolder viewHolder=new DepartmentListViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentListViewHolder holder, int position) {
        final Department data=depList.get(position);
        holder.txtId.setText(String.valueOf(depList.get(position).D_id));

//        holder.txtId.setText( depList.get(position).D_id);
        holder.txtDept.setText(depList.get(position).D_name);

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
        return depList.size();
    }
}
