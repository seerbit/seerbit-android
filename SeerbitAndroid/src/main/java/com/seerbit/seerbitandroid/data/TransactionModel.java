package com.seerbit.seerbitandroid.data;

import android.webkit.JavascriptInterface;

public class TransactionModel {
    String tranref, currency, email, description, full_name, country, callbackurl, public_key, pocketReference, vendorId, version;
    int amount;

    public TransactionModel(String tranref,
                            String currency,
                            String email,
                            String description,
                            String full_name,
                            String country,
                            String callbackurl,
                            String public_key,
                            String pocketReference,
                            String vendorId,
                            String version,
                            int amount) {
        this.tranref = tranref;
        this.currency = currency;
        this.email = email;
        this.description = description;
        this.full_name = full_name;
        this.country = country;
        this.callbackurl = callbackurl;
        this.public_key = public_key;
        this.pocketReference = pocketReference;
        this.vendorId = vendorId;
        this.version = version;
        this.amount = amount;
    }

    public TransactionModel() {
    }

    @JavascriptInterface
    public String getTranref() {
        return tranref;
    }

    @JavascriptInterface
    public void setTranref(String tranref) {
        this.tranref = tranref;
    }

    @JavascriptInterface
    public String getCurrency() {
        return currency;
    }

    @JavascriptInterface
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JavascriptInterface
    public String getEmail() {
        return email;
    }

    @JavascriptInterface
    public void setEmail(String email) {
        this.email = email;
    }

    @JavascriptInterface
    public String getDescription() {
        return description;
    }

    @JavascriptInterface
    public void setDescription(String description) {
        this.description = description;
    }

    @JavascriptInterface
    public String getFull_name() {
        return full_name;
    }

    @JavascriptInterface
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @JavascriptInterface
    public String getCountry() {
        return country;
    }

    @JavascriptInterface
    public void setCountry(String country) {
        this.country = country;
    }

    @JavascriptInterface
    public String getCallbackurl() {
        return callbackurl;
    }

    @JavascriptInterface
    public void setCallbackurl(String callbackurl) {
        this.callbackurl = callbackurl;
    }

    @JavascriptInterface
    public String getPublic_key() {
        return public_key;
    }

    @JavascriptInterface
    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    @JavascriptInterface
    public String getPocketReference() {
        return pocketReference;
    }

    @JavascriptInterface
    public void setPocketReference(String pocketReference) {
        this.pocketReference = pocketReference;
    }

    @JavascriptInterface
    public String getVendorId() {
        return vendorId;
    }

    @JavascriptInterface
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @JavascriptInterface
    public String getVersion() {
        return version;
    }

    @JavascriptInterface
    public void setVersion(String version) {
        this.version = version;
    }

    @JavascriptInterface
    public int getAmount() {
        return amount;
    }

    @JavascriptInterface
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
