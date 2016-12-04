package com.example.lucas.cardproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by lucas on 26/10/2016.
 */

public class TabFragmentC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(container == null)
            return null;

        return (RelativeLayout)inflater.inflate(R.layout.tab_layout_c, container, false);
    }
}
