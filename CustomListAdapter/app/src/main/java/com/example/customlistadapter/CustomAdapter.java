package com.example.customlistadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
    String[] names;
    String[] contacts;
    Integer[] images;
    Activity context;
    int resource;

    public CustomAdapter(@NonNull Activity context, int resource,String[] names,String[] contacts,Integer[] images) {
        super(context, resource,names);
        this.names=names;
        this.contacts=contacts;
        this.images=images;
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(resource,null,true);

        TextView txtName=rowView.findViewById(R.id.txtName);
        TextView txtContact=rowView.findViewById(R.id.txtContact);
        ImageView img=rowView.findViewById(R.id.img);

        txtName.setText(names[position]);
        txtContact.setText(contacts[position]);
        img.setImageResource(images[position]);

        return rowView;
    }
}
