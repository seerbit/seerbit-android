package com.seerbit.seerbitandroid.interfaces;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class Callback {
    public static final String TAG = Callback.class.getSimpleName();
    private Context mContext;
    private eventsListener listener;

    public Callback(Context mContext, eventsListener listener) {
        this.mContext = mContext;
        this.listener = listener;
    }

    /**
     * Javascript interface for listening to callback events
     * @param response
     */
    @JavascriptInterface
    public void onCallback(String response){
        this.listener.onCallback(response);
    }

    /**
     * Javascript interface for listening to close events
     * @param response
     */
    @JavascriptInterface
    public void onClose(String response){
        this.listener.onClose(response);
    }


    /**
     * Interface that events on the javascript
     */
    public interface eventsListener {
        /**
         * @param response reponse from javascript
         */
        void onCallback(String response);

        /**
         *
         * @param response
         */
        void onClose(String response);
    }
}
