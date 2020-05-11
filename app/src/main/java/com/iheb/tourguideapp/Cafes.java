package com.iheb.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cafes extends Fragment {
    ListView cafe;
    public Cafes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        cafe = getView().findViewById(R.id.cafe_list);
        final ArrayList<place> list = new ArrayList<place>();
        list.add(new place(getString(R.string.Beb_Al_Medina_Cafe),26936159,R.drawable.bebelmedinacafe,getString(R.string.Lunchatthemedina)));
        list.add(new place(getString(R.string.TheFirst),32654987,R.drawable.thefirstcofferesto,getString(R.string.Superbservice)));
        list.add(new place(getString(R.string.MioMondo),68951753,R.drawable.miomondo,getString(R.string.MioMondoMyWorld)));
        list.add(new place(getString(R.string.ElKasbah),86426872,R.drawable.elkasbah,getString(R.string.FreshOrangeJuice)));
        list.add(new place(getString(R.string.MoliendoCafe),65481293,R.drawable.moliendocafe,getString(R.string.Cafemoderne)));
        list.add(new place(getString(R.string.Viking),55369852,R.drawable.viking,getString(R.string.Savinggrace)));
        list.add(new place(getString(R.string.RestaurantCafe),3516285,R.drawable.restaurantafe,getString(R.string.rooftopterrace)));
        cafe.setAdapter(new placeAdapter(getContext(),R.layout.llist_item,list));
        cafe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
