package com.seerbit.seerbitandroid.view.webviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.seerbit.seerbitandroid.client.SeerbitChromeClient;
import com.seerbit.seerbitandroid.data.RedirectModel;
import com.seerbit.seerbitandroid.data.TransactionModel;
import com.seerbit.seerbitandroid.interfaces.Callback;
import com.seerbit.seerbitandroid.utils.JSTestJV;
import com.seerbit.seerbitandroid.view.presentation.SeerbitView;

public class SeerbitWebView extends WebView implements Callback.eventsListener{
    public static final String TAG = SeerbitWebView.class.getSimpleName();
    Context context;
    onRedirect onRedirect;
    onSuccessfulPayment onSuccessfulPayment;

    public SeerbitWebView(@NonNull Context context, @NonNull TransactionModel transactionModel, onRedirect onRedirect, onSuccessfulPayment onSuccessfulPayment) {
        super(context);
        context = context;
        initView(context, transactionModel);
        this.onRedirect = onRedirect;
        this.onSuccessfulPayment = onSuccessfulPayment;
    }

    @SuppressLint({ "SetJavaScriptEnabled" })
    private void initView(Context context, TransactionModel transactionModel){
        Log.d(TAG, "initView: ");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getSettings().setJavaScriptEnabled(true);
        this.setWebChromeClient(new SeerbitChromeClient());
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);
        this.addJavascriptInterface(new JSTestJV(context), "Logger");
        this.addJavascriptInterface(new Callback(context, SeerbitWebView.this), "AndroidFunction");
        this.loadData(getHtml(transactionModel), "text/HTML", "UTF-8");
    }

    protected String getHtml(TransactionModel transactionModel){
        return "<!DOCTYPE >\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <script type=\"text/javascript\">\n" +
                "    function paywithSeerbit() {\n" +
                "                 SeerbitPay({\n" +
                "                 tranref: \""+ transactionModel.getTranref() + "\",\n" +
                "                 currency: \""+ transactionModel.getCurrency() + "\",\n" +
                "                 email: \""+ transactionModel.getEmail() + "\",\n"+
                "                 full_name: \""+transactionModel.getFull_name() + "\",\n"+
                "                 description: \""+ transactionModel.getDescription() + "\",\n" +
                "                 country: \""+ transactionModel.getCountry() + "\",\n" +
                "                 amount: "+ transactionModel.getAmount() + ",\n" +
                "                 callbackurl: \""+ transactionModel.getCallbackurl() + "\",\n" +
                "                 public_key: \""+ transactionModel.getPublic_key() + "\",\n" +
                "                 narrator: \"seerbit-react-native\",\n"+
                "                 report_link: \"\",\n"+
                "                 pocketReference: \""+transactionModel.getPocketReference()+"\",\n"+
                "                 vendorId: \""+transactionModel.getVendorId()+"\",\n"+
                "                 version: \"0.2.0\"\n"+
                "                },\n" +
                "                function callback(response) {\n" +
                "                 var resp = JSON.stringify({event:'callback', response});" +
                "                 AndroidFunction.onCallback(resp);\n" +
                "                 Logger.log(resp);\n"+
                "                },\n" +
                "                function close(close) {\n" +
                "                 var resp = JSON.stringify({event:'cancelled'});\n" +
                "                 AndroidFunction.onClose(resp);\n"+
                "                })\n" +
                "               }" +
                "     </script>\n" +
                "  </head>\n" +
                "  <body onload=\"javascript:return paywithSeerbit();\">\n" +
                "        <form>\n" +
                "            <script src=\"https://checkout.seerbitapi.com/api/v2/seerbit.js\"></script>\n" +
                "        </form>" +
                "  </body>\n" +
                "</html>";
    }

    @Override
    public void onCallback(String response) {
        try{
            RedirectModel data =new RedirectModel() ;
            Gson gson = new Gson();
            data= gson.fromJson(response,RedirectModel.class);

            Log.d(TAG, "vvvonCallback: "+data.getRedirectLink().toString());
            Log.d(TAG, "vvvonCallback: "+response);
            onRedirect.redirct(data.getRedirectLink());
        }
        catch (Exception e){
            // Payment doesn't require redirect
            Log.d(TAG, "vvvonCallback: close called"+e.getMessage());
            onSuccessfulPayment.onSuccess();
        }
    }

    @Override
    public void onClose(String response) {
        Log.d(TAG, "vvvonCallback: "+response);
    }

    public interface onRedirect{
        void redirct(String url);
    }

    public interface onSuccessfulPayment{
        void onSuccess();
    }
}


