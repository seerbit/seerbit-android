package com.seerbit.seerbitandroid.client;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class SeerbitChromeClient extends WebChromeClient {
    public static final String TAG = SeerbitChromeClient.class.getSimpleName();
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.d(TAG, "onJsConfirm: "+message);
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Log.d(TAG, "onJsConfirm: "+message);
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Log.d(TAG, "onJsConfirm: "+message);
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }
}
