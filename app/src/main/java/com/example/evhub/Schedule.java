package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Method which creates the schedule fragment for the app
 */
public class Schedule extends Fragment {

    /**
     * Method in order to create the notifications fragment
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @param savedInstanceState the Bundle which groups the fragments together
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_schedule, null);
        return v;
    }
}
