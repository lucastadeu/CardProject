package com.example.lucas.cardproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tawan on 03/12/2016.
 */

public class CartaoAdapter extends ArrayAdapter<Cartao> {

    public CartaoAdapter(Context context, int resource, List<Cartao> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.card_adapter, null);
        }

        Cartao cartao = getItem(position);

        if (cartao != null) {
            TextView tvName = (TextView) view.findViewById(R.id.card_item_nome);
            TextView tvNumero = (TextView) view.findViewById(R.id.card_item_numero);

            if (tvName != null) {
                tvName.setText(cartao.getNome());
            }

            if (tvNumero!= null) {
                tvNumero.setText(cartao.getNumero());
            }

        }

        return view;
    }
}
