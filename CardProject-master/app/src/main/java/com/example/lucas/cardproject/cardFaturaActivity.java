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

public class cardFaturaActivity extends AppCompatActivity {

    private List<Cartao> cartoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_fatura);


        //tem que preencher a tela com os cartoes que vem do web service
        ListView lista = (ListView) findViewById(R.id.lista_cartao_fatura);
        final CartaoAdapter carAdap = new CartaoAdapter(this, R.layout.card_adapter, cartoes);
        lista.setAdapter(carAdap);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o lancamento activity
                Intent intent = new Intent(cardFaturaActivity.this, LancamentoActivity.class);
                intent.putExtra(LancamentoActivity.EXTRA_CARTAO, (Serializable) cartoes.get(position));
                startActivity(intent);
            }
        });
    }
}
