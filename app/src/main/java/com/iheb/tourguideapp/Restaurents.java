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
public class Restaurents extends Fragment {
    ListView restaurent;
    public Restaurents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        restaurent = getView().findViewById(R.id.restaurent_list);
        final ArrayList<place> list = new ArrayList<place>();
        list.add(new place(getString(R.string.LePirate),27985314,R.drawable.lepirate,getString(R.string.foodrestaurant)));
        list.add(new place(getString(R.string.MarinatheCaptain),56231987,R.drawable.marinathecaptain,getString(R.string.standardofcuisine)));
        list.add(new place(getString(R.string.Soprano),973215645,R.drawable.soprano,getString(R.string.BestpizzainMonastir)));
        list.add(new place(getString(R.string.Alibar),92369147,R.drawable.alibar,getString(R.string.Greatforbacon)));
        list.add(new place(getString(R.string.DarChraka),26951753,R.drawable.darchakra,getString(R.string.harissaandtuna)));
        list.add(new place(getString(R.string.MalibuSpaceRestaurant),54369951,R.drawable.malibuspacerestaurant,getString(R.string.AMust)));
        list.add(new place(getString(R.string.Alhambra),9637415,R.drawable.alhambra,getString(R.string.BOSSNEED)));
        list.add(new place(getString(R.string.OstaniaRestaurant),7419635,R.drawable.lostaniarestaurant,getString(R.string.wonderfulfish)));
        list.add(new place(getString(R.string.SavanaClub),29637418,R.drawable.savanaclub,getString(R.string.nice)));
        list.add(new place(getString(R.string.CalypsoRestaurant),58962175,R.drawable.calypso,getString(R.string.Bestseafood)));
        restaurent.setAdapter(new placeAdapter(getContext(),R.layout.llist_item,list));
        restaurent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
