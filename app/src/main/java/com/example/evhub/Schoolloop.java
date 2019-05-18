package com.example.evhub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Method which creates thes schoolloop fragment for the app
 */
public class Schoolloop extends Fragment {
    private WebView browser;
    private View v;
    private Handler handler = new Handler() {
        @Override
        /**
         * Method which handles the action when the user goes back in tha app.
         * @param message to display when the user wants to exit the app
         */
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1: {
                    webViewGoBack();
                }
                break;
            }
        }
    };

    /**
     * Method which allows the browser to go back
     */
    private void webViewGoBack(){
        browser.goBack();
    }
    @Override

    /**
     * Method in order to create the schoolloop fragment
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groups the fragments together
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_schoolloop, null);
        browser = (WebView) v.findViewById(R.id.webView);
        WebSettings settings = browser.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.getSettings().setBuiltInZoomControls(false);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setAppCacheEnabled(true);
        browser.loadUrl("https://evhs.schoolloop.com/portal/login");
        browser.setDownloadListener(new DownloadListener() {
            /**
             * Method to deal with the browser activity
             * @param url
             * @param userAgent
             * @param contentDisposition
             * @param mimetype
             * @param contentLength
             */
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        browser.setOnKeyListener(new View.OnKeyListener(){
            /**
             * Method which determines whether the browser can go back or not
             * @param v
             * @param keyCode
             * @param event
             * @return If the browser can go back or not
             */
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && browser.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }
        });
        return v;
    }
}