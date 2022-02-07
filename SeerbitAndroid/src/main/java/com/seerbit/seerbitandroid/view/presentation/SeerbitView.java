package com.seerbit.seerbitandroid.view.presentation;

import android.app.Activity;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.seerbit.seerbitandroid.view.webviews.SuccessModel;
import com.seerbit.seerbitandroid.view.webviews.TransactionModel;
import com.seerbit.seerbitandroid.view.webviews.CongratsWebview;
import com.seerbit.seerbitandroid.view.webviews.SeerbitRedirectWebview;
import com.seerbit.seerbitandroid.view.webviews.SeerbitWebView;

import java.util.Timer;
import java.util.TimerTask;

public class SeerbitView extends FrameLayout implements
        SeerbitWebView.onRedirect,
        SeerbitWebView.onSuccessfulPayment,
        SeerbitRedirectWebview.onCongratsWebViewNeeded,
        CongratsWebview.onSuccessfulPayment{
    SeerbitWebView seerbitWebView;
    SeerbitRedirectWebview seerbitRedirectWebview;
    Activity context;
    TransactionModel transactionModel;
    EventsListener onComplete;

    public SeerbitView(@NonNull Activity context) {
        super(context);
        this.context = context;
    }

    public void open(TransactionModel transactionModel) {
        if (seerbitWebView != null){
            removeView(seerbitWebView);
            seerbitWebView = null;
        }
        this.transactionModel = transactionModel;
        seerbitWebView = new SeerbitWebView(context, transactionModel, this, this);
        seerbitWebView.initView(context, transactionModel);
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

    public void addEventListener(EventsListener eventsListener){
        this.onComplete= eventsListener;
    }

    public void close(){
        SeerbitView view = this;
        seerbitWebView = null;
        seerbitRedirectWebview = null;
        this.transactionModel = null;
        this.onComplete = null;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(GONE);
            }
        });
    }

    @Override
    public void onSuccess(SuccessModel successModel) {
        Log.d("Debug", "onClose: onCLose callse");
        if(transactionModel.isClose_on_success()){
            close();
        }
        else{
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    //if (transactionModel.isClose_on_success()) close();
                    onComplete.OnCompleteListener(successModel);
                }
            }, 2000);
        }
    }

    @Override
    public void onClose() {
        onComplete.onCloseListener();
    }

    @Override
    public void onError() {
        onComplete.onError();
    }

    Boolean loaded = false;
    @Override
    public void onCongrats(String url) {
        SeerbitView view = this;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("Tag", "run: "+url);
                //if (url.contains("vers=one") || url.contains("vers=two") && url.contains("pubk="+transactionModel.getPublic_key())){
                if (!loaded){
                    transactionModel.setReportLink(url);
                    seerbitWebView.loadhtml(transactionModel);
                    removeView(seerbitRedirectWebview);
                    addView(seerbitWebView);
                    loaded = true;
                }
                //}
            }
        });
    }

    @Override
    public void onCongratsSuccess() {

    }

    public interface EventsListener{
        void OnCompleteListener(SuccessModel successModel);
        void onCloseListener();
        void onError();
    }
}
