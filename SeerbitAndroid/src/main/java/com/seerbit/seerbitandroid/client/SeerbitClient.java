package com.seerbit.seerbitandroid.client;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.seerbit.seerbitandroid.view.webviews.CongratsWebview;

public class SeerbitClient extends WebViewClient {
    public static final String TAG = SeerbitClient.class.getSimpleName();
    onOverrideUrlLoading onOverrideUrlLoading;

    public SeerbitClient(SeerbitClient.onOverrideUrlLoading onOverrideUrlLoading) {
        this.onOverrideUrlLoading = onOverrideUrlLoading;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d(TAG, "shouldOverrideUrlLoading: "+url);
        onOverrideUrlLoading.overrideUrlLoading(url);
        return true;
    }

    @Override public void onPageFinished(WebView view, String url) {

    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Log.d(TAG, "onPageStarted: called");
        super.onPageStarted(view, url, favicon);
    }

    public interface onOverrideUrlLoading{
        void overrideUrlLoading(String url);
    }

}
