package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Class which implements the google form into the social fragment
 */
public class Form extends Social {

    @Override

    /**
     * Method which creates view for the google form.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the google form view
     */
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
