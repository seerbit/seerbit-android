package com.seerbit.seerbitandroid.view.webviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.seerbit.seerbitandroid.client.SeerbitChromeClient;
import com.seerbit.seerbitandroid.client.SeerbitClient;

public class SeerbitRedirectWebview extends WebView implements
        SeerbitWebView.onSuccessfulPayment,
        SeerbitClient.onOverrideUrlLoading{
    public static final String TAG = SeerbitRedirectWebview.class.getSimpleName();
    onCongratsWebViewNeeded onCongratsWebViewNeeded;
    public SeerbitRedirectWebview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SeerbitRedirectWebview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SeerbitRedirectWebview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public SeerbitRedirectWebview(@NonNull Context context, String url, onCongratsWebViewNeeded onCongratsWebViewNeeded) {
        super(context);
        initView(context,url);
        this.onCongratsWebViewNeeded = onCongratsWebViewNeeded;
    }

    private void initView(Context context, String url) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getSettings().setJavaScriptEnabled(true);
        this.setWebChromeClient(new SeerbitChromeClient());
        this.setWebViewClient(new SeerbitClient(this));
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        this.loadUrl(url);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void overrideUrlLoading(String url) {
        onCongratsWebViewNeeded.onCongrats(url);
    }

    public interface onCongratsWebViewNeeded{
        public void onCongrats(String url);
    }
}
