package com.seerbit.seerbit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.seerbit.seerbitandroid.data.TransactionModel;
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
        String transRef = ""+System.currentTimeMillis();
        transactionModel.setTranref(transRef);
        transactionModel.setCurrency(" ");
        transactionModel.setEmail(" ");
        transactionModel.setAmount(100);
        transactionModel.setDescription("Payment of bils");
        transactionModel.setCountry("NG");
        transactionModel.setCallbackurl("https://whatever.com");
        transactionModel.setPublic_key(" ");
        transactionModel.setFull_name("Adewole Opeyemi");
        seerbitWebView = new SeerbitView(this);
        webView.addView(seerbitWebView);
        seerbitWebView.open(transactionModel);
        getSupportActionBar().hide();
    }
}