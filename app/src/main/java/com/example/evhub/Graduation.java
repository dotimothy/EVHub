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

public class Graduation extends Fragment {
    private WebView browser;
    private View v;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1: {
                    webViewGoBack();
                }
                break;
            }
        }
    };

    private void webViewGoBack() {
        browser.goBack();
    }

    @Override
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
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        browser.setOnKeyListener(new View.OnKeyListener() {
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
