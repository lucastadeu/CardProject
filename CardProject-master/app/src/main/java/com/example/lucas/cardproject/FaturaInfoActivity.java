package com.example.lucas.cardproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FaturaInfoActivity extends AppCompatActivity {

    public static final String EXTRA_LANCAMENTO = "cartao";

    private TextView tvValor = (TextView) findViewById(R.id.fatura_info_valor);
    private TextView tvData = (TextView) findViewById(R.id.fatura_info_data);
    private TextView tvlugar = (TextView) findViewById(R.id.fatura_info_lugar);
    private ImageView ivLugar = (ImageView) findViewById(R.id.fatura_info_imagem);


    //aqui vai ser os detalhes do lancamento
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura_info);
        final Lancamento lancamento = (Lancamento) getIntent().getSerializableExtra(EXTRA_LANCAMENTO);
        //aqui eu peguei a fatura q ele selecionou pra ver a info, só preencher os dados da tela com essa fatura
    }
}
