package com.seerbit.seerbitandroid.view.webviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import com.seerbit.seerbitandroid.client.SeerbitChromeClient;
import com.seerbit.seerbitandroid.client.SeerbitClient;

public class CongratsWebview extends WebView{
    onSuccessfulPayment onSuccessfulPayment;
    public CongratsWebview(@NonNull Context context, String url, onSuccessfulPayment onSuccessfulPayment) {
        super(context);
        initView(context, url);
        this.onSuccessfulPayment = onSuccessfulPayment;
    }
    private void initView(Context context, String url) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        this.setWebChromeClient(new SeerbitChromeClient());
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);
        this.getSettings().setAllowFileAccessFromFileURLs(true);
        this.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                onSuccessfulPayment.onCongratsSuccess();
            }
        });
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        this.loadUrl(url);
    }

    public interface onSuccessfulPayment{
        void onCongratsSuccess();
    }
}
