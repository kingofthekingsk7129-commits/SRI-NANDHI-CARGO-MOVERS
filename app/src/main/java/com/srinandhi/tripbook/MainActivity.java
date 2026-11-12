
package com.srinandhi.tripbook;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.print.PrintManager;
import android.print.PrintAttributes;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void printPage() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        PrintManager pm = (PrintManager)
                            getSystemService(Context.PRINT_SERVICE);

                        if (pm != null) {
                            pm.print(
                                "Sri Nandhi Trip Report",
                                webView.createPrintDocumentAdapter(
                                    "Trip Book"
                                ),
                                new PrintAttributes.Builder().build()
                            );
                        }
                    }
                });
            }
        }, "AndroidPrint");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.evaluateJavascript(
                    "window.print = function() {" +
                    "AndroidPrint.printPage();" +
                    "};", null
                );
            }
        });

        webView.loadUrl(
            "https://kingofthekingsk7129-commits.github.io/SRI-NANDHI-CARGO-MOVERS/"
        );
    }
}
