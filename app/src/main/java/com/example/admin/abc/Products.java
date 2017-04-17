package com.example.admin.abc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class Products extends AppCompatActivity {

    ImageView back;

    // @Written By Geetha - Code Starts Here

    final static String urlAddress = "http://192.168.0.3/abc/getProductImages.php";
  //  final static String urlAddress = "http://10.0.2.2/abc/getProductImages.php";

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

       final ListView lv = (ListView) findViewById(R.id.productLv);

       new ProductsDownloader(Products.this,urlAddress,lv).execute();

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Products.this,Main2Activity.class);
                startActivity(in);
            }
        });

    }
}

