package com.example.firefly;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        web.setBackgroundColor(Color.parseColor("#0d2b2e"));
        web.setOverScrollMode(View.OVER_SCROLL_NEVER);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);   // 讓遊戲可以用 localStorage 存最高分

        setContentView(web);
        web.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onPause()  { super.onPause();  web.onPause(); }
    @Override
    protected void onResume() { super.onResume(); web.onResume(); }
}
