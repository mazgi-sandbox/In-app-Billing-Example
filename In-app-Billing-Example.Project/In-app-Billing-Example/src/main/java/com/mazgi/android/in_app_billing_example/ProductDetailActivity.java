package com.mazgi.android.in_app_billing_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mazgi.android.in_app_billing_example.util.IabHelper;
import com.mazgi.android.in_app_billing_example.util.IabResult;
import com.mazgi.android.in_app_billing_example.util.Inventory;
import com.mazgi.android.in_app_billing_example.util.Purchase;

/**
 * Created by matsuki_hidenori on 6/11/13.
 */
public class ProductDetailActivity extends Activity implements IABDispatcherDelegate {

    Button buyButton;
    IabHelper iabHelper;
    IabHelper.QueryInventoryFinishedListener queryInventoryFinishedListener = new IabHelper.QueryInventoryFinishedListener() {
        @Override
        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
            Log.d("IAB", "query inventory finished: " + result);
            if (result.isFailure()) {
                Log.e("IAB", "failed query inventory: " + result);
                return;
            }

            for (Purchase purchase : inv.getAllPurchases()) {
                Log.d("IAB", "purchase: " + purchase);
            }
            for (String sku : inv.getAllOwnedSkus()) {
                Log.d("IAB", "sku: " + sku);
            }

            Purchase non_consumable_01 = inv.getPurchase("non_consumable_01");
            if (non_consumable_01 != null) {
                Log.d("IAB", "non_consumable_01: " + non_consumable_01);
            } else {
                Log.d("IAB", "non_consumable_01 is null.");
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        Intent intent = getIntent();
        Log.i("IAB", String.format("product_id: %s", intent.getStringExtra("PRODUCT_ID")));

        iabHelper = new IabHelper(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqsmaFEj/Xhr51u70Og5/qtfC6sIwXlEby6uk3MyhX/NqPPDlhHFgKcIO0znecLgBdZsLetk7PZt6VbTPiO8jWuF1gB1nv4vIbZhz5gGmTE9RXC0NVntOitLNTFXwme12r0Ahiy4mOTWOiS489Ww3mbIcglmnoYrL/5jvaeaX9FwLOZE0gu0nAqELQNkTjyjMlE6oSfKHZMG3Dt9DLNJLI6dQxfb16bzWNgraNCoF0cVZgsjGF5ANAtKfbIwhm7ww2m2K4+EcjXUiT2b76dbzfAj865s2QH5CGwGEpKcd/bo/GJT9LtSm4qQSO//M1VZqvq4oAvrKf5nlGy2buDfiOQIDAQAB");
        iabHelper.enableDebugLogging(true);
        iabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            @Override
            public void onIabSetupFinished(IabResult result) {
                Log.d("IAB", "setup finished.");
                if (!result.isSuccess()) {
                    Log.e("IAB", "IAB setup failed: " + result);
                    return;
                }
                iabHelper.queryInventoryAsync(queryInventoryFinishedListener);
            }
        });

        // get views
        buyButton = (Button)findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            Activity activity;
            @Override
            public void onClick(View view) {
                iabHelper.launchPurchaseFlow(activity, "consumable_01", 1, null, "");
            }
            public View.OnClickListener setActivity(Activity activity) {
                this.activity = activity;
                return this;
            }
        }.setActivity(this));
    }
}