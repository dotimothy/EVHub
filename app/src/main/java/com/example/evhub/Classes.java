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
 * Fragment which implement the classes part of the app.
 */
public class Classes extends Fragment {
    private WebView browser;
    private View v;
    private Handler handler = new Handler() {
        @Override
        /**
         * Method which handles the action when you are going back
         * @param message the message to be displayed.
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
     * Method which allows the browser to go back a webpage
     */
    private void webViewGoBack(){
        browser.goBack();
    }
    @Override

    /**
     * Method which creates the view by linking the classes xml file
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groups the fragments together
     * @return v the classes view
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_classes, null);
        browser = (WebView) v.findViewById(R.id.classView);
        WebSettings settings = browser.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.getSettings().setBuiltInZoomControls(false);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setAppCacheEnabled(true);
        browser.loadUrl("https://evhs.schoolloop.com/evcourses");
        browser.setDownloadListener(new DownloadListener() {
            /**
             * Method to prevent the site from going back further
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
             * Method which determines if the browser should go back or not.
             * @param v
             * @param keyCode
             * @param event
             * @return If the browser should go back or not
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


