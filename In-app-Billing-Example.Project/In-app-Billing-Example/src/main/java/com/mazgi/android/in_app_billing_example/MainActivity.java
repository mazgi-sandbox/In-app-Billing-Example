package com.mazgi.android.in_app_billing_example;

import android.content.Context;
import android.content.Intent;
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
        productTypesAdapter.add("Start");

//        Intent intent = new Intent(this, ProductTypeListActivity.class);
//        startActivity(intent);

        // get views
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(productTypesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Context context;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, ProductTypeListActivity.class);
                startActivity(intent);
            }
            public AdapterView.OnItemClickListener setContext(Context context) {
                this.context = context;
                return this;
            }
        }.setContext(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
