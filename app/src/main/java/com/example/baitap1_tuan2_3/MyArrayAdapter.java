package com.example.baitap1_tuan2_3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {

    Activity context=null;
    ArrayList<NhanVien> myArray=null;
    int layoutId;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context,textViewResourceId, objects);

        this.context=context;
        this.layoutId=textViewResourceId;
        this.myArray=objects;
    }

    public View getView(int p, View v, ViewGroup vg){
        LayoutInflater inflater=context.getLayoutInflater();
        v=inflater.inflate(layoutId,null);

        if (myArray.size() >0 && p>=0){
            final TextView txtDisplay=(TextView)v.findViewById(R.id.textView_Item);
            final NhanVien nv=myArray.get(p);
            txtDisplay.setText(nv.toString());
            final ImageView imageView=(ImageView)v.findViewById(R.id.imageView_Item);

            if (nv.isGender()){
                imageView.setImageResource(R.drawable.girl);
            }
            if(!nv.isGender()){
                imageView.setImageResource(R.drawable.boy);
            }
        }
        return v;
    }
}
