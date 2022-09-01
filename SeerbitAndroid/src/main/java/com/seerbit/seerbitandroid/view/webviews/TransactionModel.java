package com.seerbit.seerbitandroid.view.webviews;

import android.webkit.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

public class TransactionModel {
    private String tranref, currency, email, description, full_name, country, repost_link, callbackurl, public_key;
    private int amount;
    private boolean setAmountByCustomer = false;
    boolean close_prompt = false;
    boolean tokenize = false;
    boolean close_on_success = true;
    private String border_color = "#000000";
    private String pocketReference = "";
    private String vendorId = "";
    private String background_color = "#004C64";
    private String button_color = "#0084A0";
    private boolean confetti = true;
    private String logo = "";
    private List<String> payment_method = new ArrayList<>();

    public boolean isSetAmountByCustomer() {
        return setAmountByCustomer;
    }

    public String getBorder_color() {
        return border_color;
    }

    public void setBorder_color(String border_color) {
        this.border_color = border_color;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public String getButton_color() {
        return button_color;
    }

    public void setButton_color(String button_color) {
        this.button_color = button_color;
    }

    public boolean isConfetti() {
        return confetti;
    }

    public void setConfetti(boolean confetti) {
        this.confetti = confetti;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(List<String> payment_method) {
        this.payment_method = payment_method;
    }

    public boolean isClose_prompt() {
        return close_prompt;
    }

    public void setClose_prompt(boolean close_prompt) {
        this.close_prompt = close_prompt;
    }

    public boolean isTokenize() {
        return tokenize;
    }

    public void setTokenize(boolean tokenize) {
        this.tokenize = tokenize;
    }

    public boolean isClose_on_success() {
        return close_on_success;
    }

    public void setClose_on_success(boolean close_on_success) {
        this.close_on_success = close_on_success;
    }

    public boolean isAmountSetByCustomer() {
        return setAmountByCustomer;
    }

    public void setSetAmountByCustomer(boolean setAmountByCustomer) {
        this.setAmountByCustomer = setAmountByCustomer;
    }

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
        this.amount = amount;
        this.repost_link = "";
    }

    public TransactionModel() {
        this.repost_link = "";
        payment_method.add("\"card\"");
        payment_method.add("\"account\"");
        payment_method.add("\"transfer\"");
        payment_method.add("\"wallet\"");
        payment_method.add("\"ussd\"");
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
    public String getReportLink(){
        return repost_link;
    }

    @JavascriptInterface
    public void setReportLink(String link){
        this.repost_link = link;
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
    public int getAmount() {
        return amount;
    }

    @JavascriptInterface
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
