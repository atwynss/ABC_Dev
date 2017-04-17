package com.example.admin.abc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Brands extends AppCompatActivity {
ImageView back5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        TextView tx=(TextView)findViewById(R.id.textView4);
       back5=(ImageView)findViewById(R.id.back5);
        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Brands.this,Main2Activity.class);
                startActivity(in);
            }
        });
    }
}
