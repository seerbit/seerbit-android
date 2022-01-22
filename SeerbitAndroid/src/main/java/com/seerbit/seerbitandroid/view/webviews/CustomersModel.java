package com.seerbit.seerbitandroid.view.webviews;

import com.google.gson.annotations.SerializedName;

public class CustomersModel {
    @SerializedName("customerId")
    String customerId;
    @SerializedName("customerEmail")
    String customerEmail;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
