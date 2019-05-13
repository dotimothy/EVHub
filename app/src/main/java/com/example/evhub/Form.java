package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Form extends Social {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form, null);
        WebView browser = (WebView) v.findViewById(R.id.form); //creating webview
        browser.getSettings().setJavaScriptEnabled(true); //enables javascipt
        browser.setWebViewClient(new WebViewClient()); //essential for opening websites in webview.
        browser.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSck9uttj32-aZnvLkIIz2sF83nzcvmbfK6grQTt57GH4RFP4Q/viewform"); //loading url for Google Form
        if(browser.canGoBack()) {
            browser.goBack();
        }
        return v;
    }
}
