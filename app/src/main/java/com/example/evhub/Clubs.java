package com.example.evhub;

import android.content.Context;
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
 * Fragment which implements the club xml file into the app
 */
public class Clubs extends Fragment {
    private WebView browser;
    private View v;
    private Handler handler = new Handler() {
        @Override
        /**
         * Method which handles the action of the back button being pressed
         * @param message the message to prompt the user
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
     * Method which makes the club website go back
     */
    private void webViewGoBack() {
        browser.goBack();
    }

    @Override

    /**
     * Method which creates the view by linking the clubs  xml file
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groips the fragments together
     * @return the view of the clubs fragment
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_clubs, null);
        browser = (WebView) v.findViewById(R.id.clubview);
        WebSettings settings = browser.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.getSettings().setBuiltInZoomControls(false);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setAppCacheEnabled(true);
        browser.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vRYD8uolgmMZPVdNtYWP5howWW7jMh6M-a-r_c4-1yPNSNSkEEYCdJ8wKjCNgeJYe1XH6Y4MjB-pNOq/pubhtml");
        browser.setDownloadListener(new DownloadListener() {
            /**
             * Method to set the data for the browser.
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
        browser.setOnKeyListener(new View.OnKeyListener() {
            /**
             * Method which determines if the browser can go back or not
             * @param v
             * @param keyCode
             * @param event
             * @return If the view can be go back or not
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