package com.seerbit.seerbitandroid.view.webviews;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {
    @SerializedName("code")
    String code;
    @SerializedName("message")
    String message;
    @SerializedName("payments")
    PaymentModel payments;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaymentModel getPayments() {
        return payments;
    }

    public void setPayments(PaymentModel payments) {
        this.payments = payments;
    }

    public CustomersModel getCustomersModel() {
        return customersModel;
    }

    public void setCustomersModel(CustomersModel customersModel) {
        this.customersModel = customersModel;
    }

    @SerializedName("customers")
    CustomersModel customersModel;
}
