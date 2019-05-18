package com.example.evhub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.*

public class Social extends Fragment {
    ArrayList<String> responseArray = new ArrayList<String>();
    private int  count;
    public Social(){
        count =0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_social, null);
        Button b = (Button) v.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Form());
                fr.commit();
                count++;
            }
        });
        b.setX(0);
        b.setY(200);
        return v;
    }
    public void dataCollect(String x){
        responseArray.add(x);
    }
    public int totalResponses(){

    }

}