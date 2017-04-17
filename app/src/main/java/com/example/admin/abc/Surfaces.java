package com.example.admin.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Surfaces extends AppCompatActivity {
ImageView b,im1,im2,im3,im4,im5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaces);


        ImageView b=(ImageView)findViewById(R.id.back19);
        ImageView im1=(ImageView)findViewById(R.id.im61);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Surfaces.this,Products.class);
                startActivity(in);
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Surfaces.this,RusticSize.class);
                startActivity(in);
            }
        });
    }
}
