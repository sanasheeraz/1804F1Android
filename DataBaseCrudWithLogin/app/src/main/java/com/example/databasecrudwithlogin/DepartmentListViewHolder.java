package com.example.databasecrudwithlogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DepartmentListViewHolder extends RecyclerView.ViewHolder{

    public TextView txtId,txtDept;

    public DepartmentListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.txtId=itemView.findViewById(R.id.txtId);
        this.txtDept=itemView.findViewById(R.id.txtdept);

    }
}
