package com.mazgi.android.in_app_billing_example;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    // data source
    ArrayAdapter<String> productTypesAdapter;

    // views
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item);

        //TODO: temporarily hard-coding
        productTypesAdapter.add("product 01");
        productTypesAdapter.add("product 02");
        productTypesAdapter.add("product 03");

        // get views
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(productTypesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO:
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
