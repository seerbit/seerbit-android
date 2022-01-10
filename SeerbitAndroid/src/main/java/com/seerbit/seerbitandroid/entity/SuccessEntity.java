package com.seerbit.seerbitandroid.entity;

import com.google.gson.annotations.SerializedName;
import com.seerbit.seerbitandroid.data.SuccessModel;

public class SuccessEntity {
    @SerializedName("event")
    private String event;

    @SerializedName("response")
    private SuccessModel successModel;

    @SerializedName("close")
    private Object close;

    public Object getClose() {
        return close;
    }

    public void setClose(Object close) {
        this.close = close;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public SuccessModel getSuccessModel() {
        return successModel;
    }

    public void setSuccessModel(SuccessModel successModel) {
        this.successModel = successModel;
    }
}
