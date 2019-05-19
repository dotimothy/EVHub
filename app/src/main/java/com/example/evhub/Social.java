package com.example.evhub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import java.util.ArrayList;

/**
 * Class to make the social fragment for the app
 */
public class Social extends Fragment {
    private WebView browser;
    private View v;
    private ArrayList<String> responses = new ArrayList<String>();
    private int responseCounter = 0;
    private Handler handler = new Handler() {
        @Override
        /**
         * Method which handles messages for the app if the user wants to go back
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
     * Method which makes the browser go back
     */
    private void webViewGoBack(){
        browser.goBack();
    }
    @Override
    /**
     * Method in order to create the social fragment
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groups the fragments together
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_social, null);
        browser = (WebView) v.findViewById(R.id.responses);
        WebSettings settings = browser.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.getSettings().setBuiltInZoomControls(false);
        browser.setWebViewClient(new WebViewClient());
        browser.getSettings().setAppCacheEnabled(true);
        browser.loadUrl("https://docs.google.com/spreadsheets/d/1KhwzHEI3jkgEMF0NIruOOFD9Lz58WoKACp6ggl5o_Fo/edit?ouid=115853807377850464165&usp=sheets_home&ths=true");
        browser.setDownloadListener(new DownloadListener() {
            /**
             * Method which sets the activity for the browser
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
             * Method which dertermines if the browser can go back or not
             * @param v
             * @param keyCode
             * @param event
             * @return if the browser can go back or not
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
        Button b = (Button) v.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which allows the button to be clicked
             * @param v the view to link the button to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Form());
                addResponse();
                fr.commit();
            }
        });
        b.setX(0);
        b.setY(200);
        for (int i = 0; i < responses.size(); i++) {
            System.out.println((responses.get(i)));
        }
        return v;
    }

    /**
     * Method used to log the amount of times the user clicks the google form button with an ArrayList response
     * For developers only
     */
    public void addResponse() {
        responseCounter++;
        if(responseCounter == 1) {
            responses.add("The google form has been clicked " + responseCounter + " time");
        } else {
            responses.add("The google form has been clicked " + responseCounter + " times ");
        }
    }
}
