package com.example.lucas.cardproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartaoActivity extends AppCompatActivity {
//esse cartao activity é pra parte do perda ou roubo
    private List<Cartao> cartoes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);

        Cartao bla = new Cartao();
        bla.setNome("cartao Master");
        bla.setNumero("2425784");
        cartoes.add(bla);

        ListView lista = (ListView) findViewById(R.id.card_list);
        final CartaoAdapter carAdap = new CartaoAdapter(this, R.layout.card_adapter, cartoes);
        lista.setAdapter(carAdap);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alertaConfirmar();
            }
        });
    }

    private AlertDialog alerta;


    private void alertaConfirmar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Perda ou Roubo de Cartão");
        builder.setMessage("Você confirma que este cartão foi roubado ou perdido?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(CartaoActivity.this, "Informado" , Toast.LENGTH_SHORT).show();//mandar pro web service
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(CartaoActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();//apenas cancelar
            }
        });
        alerta = builder.create();
        alerta.show();
    }
}
