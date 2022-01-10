package com.seerbit.seerbitandroid.utils;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSTestJV {
    public static final String TAG = JSTestJV.class.getSimpleName();
    Context mContext;

    public JSTestJV(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void log(String toast) {
        Log.d(TAG, "Debugginng toast: "+toast);
     }
}
