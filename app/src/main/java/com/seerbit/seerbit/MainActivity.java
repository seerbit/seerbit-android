package com.seerbit.seerbit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.seerbit.seerbitandroid.view.webviews.SuccessModel;
import com.seerbit.seerbitandroid.view.webviews.TransactionModel;
import com.seerbit.seerbitandroid.view.presentation.SeerbitView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    SeerbitView seerbitWebView;
    FrameLayout webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        TransactionModel transactionModel = new TransactionModel();
        String transRef = String.valueOf(System.currentTimeMillis());
        transactionModel.setTranref(transRef);
        transactionModel.setCurrency("NGN");
        transactionModel.setEmail("adewoleopw@gmail.com");
        transactionModel.setAmount(1000);
        transactionModel.setDescription("LIVE");
        transactionModel.setCountry("NG");
        transactionModel.setCallbackurl("");
        transactionModel.setPublic_key("SBTESTPUBK_y9xF4issbbpKaMEnP5Fv4y0u75523ko2");
        transactionModel.setFull_name("Adewole Opeyemi");
        seerbitWebView = new SeerbitView(this);
        webView.addView(seerbitWebView);
        seerbitWebView.open(transactionModel);
        seerbitWebView.addEventListener(new SeerbitView.EventsListener() {
            @Override
            public void OnCompleteListener(SuccessModel successModel) {
                //get data associated with transaction
                Log.d(TAG, "OnCompleteListener: "+successModel.getResponse().getPayments().getCountry());
                //seerbitWebView.close();
            }

            @Override
            public void onCloseListener() {
                //Case whem the user cancels the transaction manually
                seerbitWebView.close();
            }

            @Override
            public void onError() {
                //Something went wrong close transaction
                seerbitWebView.close();
            }

        });
        getSupportActionBar().hide();
    }
}