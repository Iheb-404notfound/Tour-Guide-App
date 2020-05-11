package com.iheb.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Maximized extends AppCompatActivity {
    ImageView img;
    TextView phone;
    TextView description;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maximized);
        img=findViewById(R.id.m_image);
        phone= findViewById(R.id.phone_number);
        description = findViewById(R.id.description);
        title=findViewById(R.id.titletxt);
        Intent intent = getIntent();
        img.setImageResource(intent.getIntExtra("img",R.drawable.alhambra));
        phone.setText(String.valueOf(intent.getIntExtra("phone",2766838)));
        description.setText(intent.getStringExtra("desc"));
        title.setText(intent.getStringExtra("title"));
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+phone.getText().toString()));
                startActivity(call);
            }
        });
    }
}
