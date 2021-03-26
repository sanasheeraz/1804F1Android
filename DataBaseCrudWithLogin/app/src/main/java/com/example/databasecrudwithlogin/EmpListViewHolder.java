package com.example.databasecrudwithlogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpListViewHolder extends RecyclerView.ViewHolder{
    public ImageView img;
    public TextView txtName,txtEmail,txtDept;
    public LinearLayout linearLayout;

    public EmpListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.txtName=itemView.findViewById(R.id.txtname);
        this.txtEmail=itemView.findViewById(R.id.txtemail);
        this.txtDept=itemView.findViewById(R.id.txtdept);
        this.img=itemView.findViewById(R.id.img);

        this.linearLayout = itemView.findViewById(R.id.layout);
    }
}
