package com.example.admin.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Decoratives extends AppCompatActivity {
ImageView d1;
    ImageView dc1,dc2,dc3,dc4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoratives);
        d1=(ImageView)findViewById(R.id.back31);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Decoratives.this,Products.class);
                startActivity(in);
            }
        });

        dc1=(ImageView)findViewById(R.id.im51);
        dc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Decoratives.this,ArtificialGrass.class);
                startActivity(in);
            }
        });
    }
}
