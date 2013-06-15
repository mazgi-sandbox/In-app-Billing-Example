package com.mazgi.android.in_app_billing_example;

/**
 * Created by matsuki_hidenori on 6/14/13.
 */
public class IAPDispatcher {
    private IABDispatcherDelegate delegate = null;

    public void prepare() {

    }
    public void loadProducts() {

    }
    public void purchaseProduct() {

    }
    public IABDispatcherDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(IABDispatcherDelegate delegate) {
        this.delegate = delegate;
    }
}
