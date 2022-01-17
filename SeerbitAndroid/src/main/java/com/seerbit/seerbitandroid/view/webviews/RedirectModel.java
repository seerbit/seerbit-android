package com.seerbit.seerbitandroid.view.webviews;

import com.google.gson.annotations.SerializedName;

public class RedirectModel {
    @SerializedName("event")
    String event;

    @SerializedName("response")
    String redirectLink;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }
}
