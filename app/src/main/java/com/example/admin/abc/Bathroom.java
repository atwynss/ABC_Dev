package com.example.admin.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Bathroom extends AppCompatActivity {
ImageView im1,back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);
        im1=(ImageView)findViewById(R.id.im21);
            back4=(ImageView)findViewById(R.id.back4);
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Bathroom.this,Products.class);
                startActivity(in);
            }
        });



        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Bathroom.this,BasinsSize.class);
                startActivity(in);
            }
        });
    }
}
