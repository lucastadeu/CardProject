package com.example.lucas.cardproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tawan on 04/12/2016.
 */

public class LancamentoAdapter extends ArrayAdapter<Lancamento> {

    public LancamentoAdapter(Context context, int resource, List<Lancamento> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.fatura_adapter, null);
        }

        Lancamento lancamento = getItem(position);

        if (lancamento != null) {
            TextView tvLugar = (TextView) view.findViewById(R.id.fatura_item_lugar);
            TextView tvValor = (TextView) view.findViewById(R.id.fatura_item_valor);
            TextView tvData = (TextView) view.findViewById(R.id.fatura_item_data);

            if (tvLugar != null) {
                tvLugar.setText(lancamento.getLugar());
            }

            if (tvValor!= null) {
                tvValor.setText(lancamento.getValor());
            }

            if (tvData!= null) {
                tvData.setText(lancamento.getData());
            }
        }

        return view;
    }
}
