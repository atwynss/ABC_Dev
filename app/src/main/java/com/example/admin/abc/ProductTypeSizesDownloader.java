package com.example.admin.abc;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Geetha on 4/14/2017 for reading Mysql database data.
 */

public class ProductTypeSizesDownloader extends AsyncTask<Void, Void, String> {
    Context c;
    String urlAddress;
    ListView lv;
    public ProductTypeSizesDownloader(Context c, String urlAddress, ListView lv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.lv = lv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        String data = downloadTypeData();
        return data;

    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s==null)
        {
            Toast.makeText(c,"Unsuccessful,Null returned",Toast.LENGTH_SHORT).show();
        }else {
            //CALL DATA PARSER TO PARSE
            ListProductTypeSizesDataParser parser=new ListProductTypeSizesDataParser(c, lv, s);
            parser.execute();
        }
    }
    private String downloadTypeData() {
        HttpURLConnection con = Connector.connect(urlAddress);
        if (con == null) {
            return null;
        }
        try {
            InputStream is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line = br.readLine()) != null) {
                jsonData.append(line + "n");
            }
            br.close();
            is.close();
            return jsonData.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

