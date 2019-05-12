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

/**
 * Created by Belal on 1/23/2018.
 */

public class Schoolloop extends Fragment {

    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_schoolloop, null);
        WebView browser = (WebView) v.findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient()); //essential for opening websites in webview.
        browser.loadUrl("https://evhs.schoolloop.com/portal/login");
        if(browser.canGoBack()) {
            browser.goBack();
        }
        return v;
    }
}