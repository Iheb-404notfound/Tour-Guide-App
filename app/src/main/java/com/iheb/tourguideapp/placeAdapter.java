package com.iheb.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class placeAdapter extends ArrayAdapter<place> {
    public placeAdapter(@NonNull Context context, int resource, @NonNull List<place> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.llist_item,parent,false);
        }
        ImageView img = view.findViewById(R.id.img);
        TextView txt = view.findViewById(R.id.txt);
        place current = getItem(position);
        txt.setText(current.getName());
        img.setImageResource(current.getImgResId());
        return view;
    }
}
