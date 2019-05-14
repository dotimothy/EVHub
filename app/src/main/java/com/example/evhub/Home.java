package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        Button b = (Button) v.findViewById(R.id.scheduleButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Schedule());
                fr.commit();
            }
        });
        Button b1 = (Button) v.findViewById(R.id.mapButton);
        b1.setOnClickListener(new View.OnClickListener() {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Map());
                fr.commit();
            }
        });
        return v;
    }
}