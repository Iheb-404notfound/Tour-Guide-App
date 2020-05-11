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

public class Hotels extends Fragment {
    ListView hotel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        hotel = getView().findViewById(R.id.hotel_list);
        final ArrayList<place> list = new ArrayList<place>();
        list.add(new place(getString(R.string.RegencyHotel),29635148,R.drawable.regencyhotelandspa,getString(R.string.fstBestValue)));
        list.add(new place(getString(R.string.VincciRosa),35151178,R.drawable.sentidorosabeach,getString(R.string.secBestValue)));
        list.add(new place(getString(R.string.HotelLibertyResort),75693417,R.drawable.libertyresort,getString(R.string.thrdBestValue)));
        list.add(new place(getString(R.string.RoyalThalassaMonastir),56951753,R.drawable.royalthalassamonastir,getString(R.string.frthBestValue)));
        list.add(new place(getString(R.string.DarBenti),65956235,R.drawable.darbenti,getString(R.string.fvthBestValue)));
        list.add(new place(getString(R.string.ClubTropicana),65956235,R.drawable.hotelclubtropicana,getString(R.string.sxthBestValue)));
        list.add(new place(getString(R.string.HotelRuspina),25796385,R.drawable.hotelruspina,getString(R.string.svnthBestValue)));
        list.add(new place(getString(R.string.AmirPalaceHotel),65951753,R.drawable.amirpalace,getString(R.string.eithBestValue)));
        list.add(new place(getString(R.string.MonastirCenterHotel),3579632,R.drawable.monastircenterhotel,getString(R.string.ninthBestValue)));
        list.add(new place(getString(R.string.HotelLesPalmiers),45686236,R.drawable.hotellespalmiers,getString(R.string.tenthBestValue)));
        hotel.setAdapter(new placeAdapter(getContext(),R.layout.llist_item,list));
        hotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
