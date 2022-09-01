package com.seerbit.seerbitandroid.view.webviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.seerbit.seerbitandroid.client.SeerbitChromeClient;
import com.seerbit.seerbitandroid.interfaces.Callback;
import com.seerbit.seerbitandroid.utils.JSTestJV;

import org.json.JSONException;
import org.json.JSONObject;

public class SeerbitWebView extends WebView implements Callback.eventsListener{
    public static final String TAG = SeerbitWebView.class.getSimpleName();
    Context context;
    onRedirect onRedirect;
    onSuccessfulPayment onSuccessfulPayment;

    public SeerbitWebView(@NonNull Context context, @NonNull TransactionModel transactionModel, onRedirect onRedirect, onSuccessfulPayment onSuccessfulPayment) {
        super(context);
        context = context;
        //initView(context, transactionModel);
        this.onRedirect = onRedirect;
        this.onSuccessfulPayment = onSuccessfulPayment;
    }

    @SuppressLint({ "SetJavaScriptEnabled" })
    public void initView(Context context, TransactionModel transactionModel){
        Log.d(TAG, "initView: ");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getSettings().setJavaScriptEnabled(true);
        this.setWebChromeClient(new SeerbitChromeClient());
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);
        this.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        this.addJavascriptInterface(new JSTestJV(context), "Logger");
        this.getSettings().setAllowFileAccessFromFileURLs(true);
        this.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.addJavascriptInterface(new Callback(context, SeerbitWebView.this), "AndroidFunction");
        this.loadData(getHtml(transactionModel), "text/HTML", "UTF-8");
    }

    protected String getHtml(TransactionModel transactionModel){
        Log.d(TAG, "getHtml: "+transactionModel.getPayment_method().toString());
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
                "                 report_link: \""+transactionModel.getReportLink()+"\",\n"+
                "                 pocketReference: \""+transactionModel.getPocketReference()+"\",\n"+
                "                 vendorId: \""+transactionModel.getVendorId()+"\",\n"+
                "                 version: \"0.2.0\",\n"+
                "                 close_prompt: "+transactionModel.isClose_prompt()+",\n"+
                "                 close_on_success:"+transactionModel.isClose_on_success()+",\n"+
                "                 tokenize:"+transactionModel.isTokenize()+",\n"+
                "                 customization: {\n"+
                "                     theme: {\n"+
               // "                         border_color: \""+transactionModel.getBorder_color()+"\",\n"+
                //"                         background_color: \""+transactionModel.getBackground_color()+"\",\n"+
               // "                         button_color: \""+transactionModel.getButton_color()+"\",\n"+
                "                        },\n"+
                "                     payment_method:"+transactionModel.getPayment_method().toString()+",\n"+
                "                     confetti:"+transactionModel.isConfetti()+",\n"+
                "                     logo:\""+transactionModel.getLogo()+"\",\n"+
                "                     }\n"+
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

    public void loadhtml(TransactionModel transactionModel){
        this.loadData(getHtml(transactionModel), "text/HTML", "UTF-8");
    }

    @Override
    public void onCallback(String response) {
        Log.d(TAG, "onCallback: "+response);
        try{
            JSONObject json = new JSONObject(response);
            String event = json.getString("event");
            if (event.contains("error")){
                onSuccessfulPayment.onError();
            }
            else{
                try{
                    RedirectModel data =new RedirectModel() ;
                    Gson gson = new Gson();
                    data= gson.fromJson(response,RedirectModel.class);
                    onRedirect.redirct(data.getRedirectLink());
                }
                catch (Exception e){
                    // Payment doesn't require redirect
                    SuccessModel successModel = new SuccessModel();
                    Gson gson = new Gson();
                    successModel = gson.fromJson(response, SuccessModel.class);
                    onSuccessfulPayment.onSuccess(successModel);
                }
            }
        }
        catch (Exception e){
            Log.d(TAG, "onCallback: "+e.getMessage());
        }
    }

    @Override
    public void onClose(String response) {
        onSuccessfulPayment.onClose();
    }

    public interface onRedirect{
        void redirct(String url);
    }

    public interface onSuccessfulPayment{
        void onSuccess(SuccessModel successModel);
        void onClose();
        void onError();
    }
}


