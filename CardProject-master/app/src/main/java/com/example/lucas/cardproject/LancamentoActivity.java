package com.example.lucas.cardproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LancamentoActivity extends AppCompatActivity {

    public static final String EXTRA_CARTAO = "cartao";

    private List<Lancamento> lancamentos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        final Cartao cartao = (Cartao) getIntent().getSerializableExtra(EXTRA_CARTAO);
        //aqui eu peguei o cartao selecionado, ai é só preencher a lista com a fatura desse cartao




        ListView lista = (ListView) findViewById(R.id.lista_fatura);
        final LancamentoAdapter adapter = new LancamentoAdapter(this, R.layout.fatura_adapter, lancamentos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o fatura info

                Intent intent = new Intent(LancamentoActivity.this, FaturaInfoActivity.class);
                intent.putExtra(FaturaInfoActivity.EXTRA_LANCAMENTO, (Serializable) lancamentos.get(position));
                startActivity(intent);
            }
        });
    }
}
