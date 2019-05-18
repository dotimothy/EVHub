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
 * Class which implements the graduation fragment to the app
 */
public class Graduation extends Fragment {
    private WebView browser;
    private View v;
    private Handler handler = new Handler() {
        @Override
        /**
         * Method which handles the message for when the user goes back
         * @param message the message to be displayed when the user goes back
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
     * Method for going back in the broser
     */
    private void webViewGoBack() {
        browser.goBack();
    }

    @Override

    /**
     * Method which creates the view for graduation
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groips the fragments together
     * @return the view of the graduation fragment
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_graduation, null);
        browser = (WebView) v.findViewById(R.id.grad);
        WebSettings settings = browser.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.getSettings().setBuiltInZoomControls(false);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setAppCacheEnabled(true);
        browser.loadUrl("https://evhs.schoolloop.com/pf4/cms2/view_page?d=x&group_id=1518855559648&vdid=i55e1sg5w153");
        browser.setDownloadListener(new DownloadListener() {
            /**
             * Method which sets up the data for the browser
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
             * Method which determines if the browser should go back or not
             * @param v
             * @param keyCode
             * @param event
             * @return if the browser should go back or not
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
