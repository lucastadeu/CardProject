package com.example.lucas.cardproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class cardFaturaActivity extends AppCompatActivity {

    private List<Cartao> cartoes = new ArrayList<>();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_fatura);

        Cartao bla = new Cartao();
        bla.setNome("cartao Master");
        bla.setNumero("2425784");

        Cartao bla2 = new Cartao();
        bla2.setNome("cartao Master");
        bla2.setNumero("2425784");

        cartoes.add(bla);
        cartoes.add(bla2);

        //tem que preencher a tela com os cartoes que vem do web service
        ListView lista = (ListView) findViewById(R.id.lista_cartao_fatura);
        final CartaoAdapter carAdap = new CartaoAdapter(this, R.layout.card_adapter, cartoes);
        lista.setAdapter(carAdap);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o lancamento activity
                Intent intent = new Intent(cardFaturaActivity.this, LancamentoActivity.class);
                //intent.putExtra(LancamentoActivity.EXTRA_CARTAO, (Parcelable) cartoes.get(position));
                startActivity(intent);
            }
        });
    }
}
