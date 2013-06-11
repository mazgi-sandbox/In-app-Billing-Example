package com.mazgi.android.in_app_billing_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by matsuki_hidenori on 6/11/13.
 */
public class ProductDetailActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        Intent intent = getIntent();
        Log.i("IAB", String.format("product_id: %s", intent.getStringExtra("PRODUCT_ID")));
    }
}