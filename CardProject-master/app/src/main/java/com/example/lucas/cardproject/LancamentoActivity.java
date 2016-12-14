package com.example.lucas.cardproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LancamentoActivity extends AppCompatActivity {

    public static final String EXTRA_CARTAO = "cartao";

    private List<Lancamento> lancamentos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        //final Cartao cartao = (Cartao) getIntent().getSerializableExtra(EXTRA_CARTAO);
        //aqui eu peguei o cartao selecionado, ai é só preencher a lista com a fatura desse cartao

        Lancamento bla = new Lancamento();
        bla.setData("26/01/2016");
        bla.setLugar("Outback campinas");
        bla.setValor("R$3000");
        lancamentos.add(bla);


        ListView lista = (ListView) findViewById(R.id.lista_fatura);
        final LancamentoAdapter adapter = new LancamentoAdapter(this, R.layout.fatura_adapter, lancamentos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o fatura info

                Intent intent = new Intent(LancamentoActivity.this, FaturaInfoActivity.class);
                //intent.putExtra(FaturaInfoActivity.EXTRA_LANCAMENTO, (Serializable) lancamentos.get(position));
                startActivity(intent);
            }
        });
    }
}
