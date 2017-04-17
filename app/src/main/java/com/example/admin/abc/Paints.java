package com.example.admin.abc;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

public class Paints extends AppCompatActivity {
ImageView im7;
    ImageView im8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paints);
        im7=(ImageView)findViewById(R.id.back28);
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Paints.this,Products.class);
                startActivity(in);
            }
        });

        im8=(ImageView)findViewById(R.id.im51);
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Paints.this,PaintsTypes.class);
                startActivity(in);
            }
        });


    }
}
