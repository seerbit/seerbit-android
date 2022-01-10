package com.seerbit.seerbitandroid.view.presentation;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.seerbit.seerbitandroid.data.TransactionModel;
import com.seerbit.seerbitandroid.interfaces.Callback;
import com.seerbit.seerbitandroid.view.webviews.CongratsWebview;
import com.seerbit.seerbitandroid.view.webviews.SeerbitRedirectWebview;
import com.seerbit.seerbitandroid.view.webviews.SeerbitWebView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class SeerbitView extends FrameLayout implements
        SeerbitWebView.onRedirect,
        SeerbitWebView.onSuccessfulPayment,
        SeerbitRedirectWebview.onCongratsWebViewNeeded,
        CongratsWebview.onSuccessfulPayment{
    SeerbitWebView seerbitWebView;
    SeerbitRedirectWebview seerbitRedirectWebview;
    Activity context;
    public SeerbitView(@NonNull Activity context) {
        super(context);
        this.context = context;
    }

    public void open(TransactionModel transactionModel) {
        if (seerbitWebView != null){
            removeView(seerbitWebView);
            seerbitWebView = null;
        }
        seerbitWebView = new SeerbitWebView(context, transactionModel, this, this);
        addView(seerbitWebView);
    }

    @Override
    public void redirct(String url) {
        SeerbitView view = this;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                seerbitRedirectWebview = new SeerbitRedirectWebview(context, url, view);
                removeView(seerbitWebView);
                addView(seerbitRedirectWebview);
            }
        });
        Log.d("TAG", "onRedirct: "+url);
    }

    public void close(){
        SeerbitView view = this;
        seerbitWebView = null;
        seerbitRedirectWebview = null;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(GONE);
            }
        });
    }

    @Override
    public void onSuccess() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 2000);
    }

    @Override
    public void onCongrats(String url) {
        SeerbitView view = this;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CongratsWebview congratsWebview = new CongratsWebview(context, url, view);
                removeView(seerbitRedirectWebview);
                addView(congratsWebview);
            }
        });
    }

    @Override
    public void onCongratsSuccess() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 4000);
    }
}
