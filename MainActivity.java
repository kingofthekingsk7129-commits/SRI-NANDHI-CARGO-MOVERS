package com.srinandhi.tripbook;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;
import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView webView;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new PrintBridge(this), "AndroidPrint");
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
    public static class PrintBridge {
        private final Activity activity;
        PrintBridge(Activity a) { activity = a; }
        @JavascriptInterface public void printPage() {
            activity.runOnUiThread(() -> {
                PrintManager pm = (PrintManager) activity.getSystemService(Context.PRINT_SERVICE);
                if (pm != null) pm.print("Sri Nandhi Trip Report",
                    ((MainActivity)activity).webView.createPrintDocumentAdapter("Trip Report"),
                    new PrintAttributes.Builder().build());
            });
        }
    }
}
