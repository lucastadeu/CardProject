package com.example.lucas.cardproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by lucas on 26/10/2016.
 */

public class TabFragmentB extends Fragment {

    int check = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(container == null)
            return null;

        //Spinner Dinâmico

        LinearLayout inflated = (LinearLayout) inflater.inflate(R.layout.tab_layout_b, container, false);
        Spinner dynamicSpinner = (Spinner) inflated.findViewById(R.id.spinnerDinamico);

        String[] items = new String[] { "Janeiro/16", "Fevereiro/16", "Março/16", "Abril/16", "Maio/16", "Junho/16", "Julho/16",
        "Agosto/16", "Setembro/16", "Outubro/16", "Novembro/16", "Dezembro/16"};

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                check = check+1;

                Log.v("item", (String) parent.getItemAtPosition(position));

                String selected = parent.getItemAtPosition(position).toString();

                if(check > 1){
                    if(selected.equals("Janeiro/16"))
                    {
                        Intent intentt = new Intent(getActivity(), Lancamentos.class);

                        startActivity(intentt);
                    }

                    else
                    {

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        return inflated;
    }
}
