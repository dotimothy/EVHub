package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Method which creates the home fragment for the app
 */
public class Home extends Fragment {
    @Nullable
    @Override
    /**
     * Method which creates the home view along with the linkable buttons
     * @param inflater the LayoutInflater which inflates the view to the app
     * @param container the ViewGroup which displays the current fragment
     * @oaram savedInstanceState the Bundle which groips the fragments together
     * @return the view of the clubs fragment
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        CardView c = v.findViewById(R.id.schedule);
        CardView c1 = v.findViewById(R.id.classes);
        CardView c2 = v.findViewById(R.id.Calender);
        CardView c3 = v.findViewById(R.id.clubs);
        CardView c4 = v.findViewById(R.id.graduation);
        CardView c5 = v.findViewById(R.id.numbers);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to schedule
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Schedule());
                fr.commit();
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to classes
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Classes());
                fr.commit();
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to calender
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Calender());
                fr.commit();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to clubs
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Clubs());
                fr.commit();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to graduation
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Graduation());
                fr.commit();
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Method which links the button to numbers
             * @param v the view to be linked to
             */
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.replace(R.id.fragment_container, new Numbers());
                fr.commit();
            }
        });
        return v;
    }
}