package com.mazgi.android.in_app_billing_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by matsuki_hidenori on 6/9/13.
 */
public class ProductTypeListActivity extends Activity {

    // data source
    ArrayAdapter<String> productTypesAdapter;

    // views
    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_type_list_activity);

        productTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item);

        //TODO: temporarily hard-coding
        productTypesAdapter.add("product 01");
        productTypesAdapter.add("product 02");
        productTypesAdapter.add("product 03");

        // get views
        listView = (ListView)findViewById(R.id.productTypeListView);
        listView.setAdapter(productTypesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO:
            }
        });
    }
}