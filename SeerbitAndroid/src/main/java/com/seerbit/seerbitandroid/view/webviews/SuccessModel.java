package com.seerbit.seerbitandroid.view.webviews;

import com.google.gson.annotations.SerializedName;

public class SuccessModel {
    @SerializedName("response")
    private ResponseModel response;

    @SerializedName("event")
    private String event;

    public ResponseModel getResponse() {
        return response;
    }

    public void setResponse(ResponseModel payment) {
        this.response = payment;
    }

    public String getCode() {
        return event;
    }

    public void setCode(String event) {
        this.event = event;
    }


}
