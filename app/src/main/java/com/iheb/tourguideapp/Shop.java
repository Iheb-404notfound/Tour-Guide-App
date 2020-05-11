package com.iheb.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Shop extends Fragment {
    ListView shop;
    public Shop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        shop = getView().findViewById(R.id.shop_list);
        final ArrayList<place> list = new ArrayList<place>();
        list.add(new place(getString(R.string.Follashoppingcenter),32165498,R.drawable.folla,getString(R.string.niceweecafenextdoor)));
        list.add(new place(getString(R.string.MahdiaOldTown),65148961,R.drawable.mahdia,getString(R.string.historictownonTunisia)));
        list.add(new place(getString(R.string.MedinaofSousse),35715962,R.drawable.sousse,getString(R.string.GreatMosqueofSousse)));
        list.add(new place(getString(R.string.MonastirMarina),35128648,R.drawable.marina,getString(R.string.bestfromabove)));
        list.add(new place(getString(R.string.RibatofMonastir),98452365,R.drawable.ribat,getString(R.string.WenttotheRibat)));
        list.add(new place(getString(R.string.ArchaeologicalMuseum),984236591,R.drawable.archeo,getString(R.string.Greatmosaics)));
        shop.setAdapter(new placeAdapter(getContext(),R.layout.llist_item,list));
        shop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                place item_clicked = list.get(position);
                Intent intent = new Intent(getContext(),Maximized.class);
                intent.putExtra("img",item_clicked.getImgResId());
                intent.putExtra("phone",item_clicked.getPhone());
                intent.putExtra("desc",item_clicked.getSammary());
                intent.putExtra("title",item_clicked.getName());
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
