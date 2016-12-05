package com.example.lucas.cardproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LancamentoActivity extends AppCompatActivity {

    private List<Lancamento> lancamentos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        //lista de lancamento

        ListView lista = (ListView) findViewById(R.id.lista_fatura);
        final LancamentoAdapter adapter = new LancamentoAdapter(this, R.layout.fatura_adapter, lancamentos);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o fatura info
            }
        });
    }
}
