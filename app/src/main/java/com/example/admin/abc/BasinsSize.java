package com.example.admin.abc;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BasinsSize extends AppCompatActivity {
//Button b1;
    ImageView back;

   // Written by Geetha -- Code start's here

    ListView ProductListView;
    ArrayList<ProductSizeImages> productSizeImagesArrayList = new ArrayList<>();


  final static String URL = "http://10.0.2.2/abc/products/AllProductData.php";



    List<String> IdList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basins_size);
        ProductListView = (ListView) findViewById(R.id.listView1);

        back=(ImageView)findViewById(R.id.backone);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(BasinsSize.this,Bathroom.class);
                startActivity(in);
            }
        });

        // Written by Geetha code start's here

       new GetHttpProductsResponse(BasinsSize.this).execute();

        ProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Intent intent = new Intent(BasinsSize.this, ProductsFinalDetailsView.class);
               // intent.putExtra("ProductId",productSizeImagesArrayList.get(position).getTypeid());
               // startActivityForResult(intent, 0);
               String productList = String.valueOf(parent.getItemAtPosition(position));
               Log.d("id value",">" + id);
            if(position ==0){
                    // code specific to first list item

                   Intent myIntent = new Intent(view.getContext(), Basins.class);
                   startActivityForResult(myIntent, 0);
                }
            }
        });

    }

  // JSON parse class started from here.
  private class GetHttpProductsResponse extends AsyncTask<Void, Void, Void>
  {
      public Context context;

      String JSonResult;

      List<Product> productList;

      public GetHttpProductsResponse(Context context)
      {
          this.context = context;
      }

      @Override
      protected void onPreExecute()
      {
          super.onPreExecute();
      }

      @Override
      protected Void doInBackground(Void... arg0)
      {
          // Passing HTTP URL to HttpServicesClass Class.
          HttpServicesClass httpServicesClass = new HttpServicesClass(URL);
          try
          {
              httpServicesClass.ExecutePostRequest();

              if(httpServicesClass.getResponseCode() == 200)
              {
                  JSonResult = httpServicesClass.getResponse();

                  Log.d("result response: ", "> " + JSonResult);

                  if(JSonResult != null)
                  {
                      JSONArray jsonArray = null;

                      try {
                          jsonArray = new JSONArray(JSonResult);

                          JSONObject jsonObject;

                          Product products;

                          productList = new ArrayList<Product>();


                          for(int i=0; i<jsonArray.length(); i++)
                          {
                              products = new Product();

                              jsonObject = jsonArray.getJSONObject(i);

                              // Adding Product Id TO IdList Array.
                              IdList.add(jsonObject.getString("product_id").toString());
                              IdList.add(jsonObject.getString("product_name").toString());
                              IdList.add(jsonObject.getString("product_width").toString());
                              IdList.add(jsonObject.getString("product_height").toString());


                              //Adding Product Name.
                              products.ProductId = jsonObject.getString("product_id");
                              products.ProductName = jsonObject.getString("product_name").toString();
                              products.ProductHeight = jsonObject.getString("product_height").toString();
                              products.ProductWidth = jsonObject.getString("product_width").toString();

                              productList.add(products);

                          }
                      }
                      catch (JSONException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                      }
                  }
              }
              else
              {
                  Toast.makeText(context, httpServicesClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
              }
          }
          catch (Exception e)
          {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          return null;
      }

      @Override
      protected void onPostExecute(Void result)

      {
         // progressBar.setVisibility(View.GONE);

          ProductListView.setVisibility(View.VISIBLE);

          ListAdapterClass adapter = new ListAdapterClass(productList, context);

          ProductListView.setAdapter(adapter);

      }
  }

}
