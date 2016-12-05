package com.example.lucas.cardproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        //lista de cartoes

        ListView lista = (ListView) findViewById(R.id.lista_cartao_fatura);
        final CartaoAdapter carAdap = new CartaoAdapter(this, R.layout.card_adapter, cartoes);
        lista.setAdapter(carAdap);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vai chamar o lancamento activity
            }
        });
    }
}
