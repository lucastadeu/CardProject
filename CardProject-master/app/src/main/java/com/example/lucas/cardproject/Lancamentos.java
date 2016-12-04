package com.example.lucas.cardproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Lancamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamentos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RelativeLayout inflated = (RelativeLayout) inflater.inflate(R.layout.tab_layout_b, container, false);
        ListView lvInvoices = (ListView)findViewById(R.id.lvInvoices);

        //ListView listView = (ListView) findViewById(R.id.lvInvoices);
        ArrayList<InvoicesData> invoices = gerarDados();
        ArrayAdapter<InvoicesData> adapterInvoice = new ArrayAdapter<InvoicesData>(this, android.R.layout.simple_list_item_1, invoices);
        lvInvoices.setAdapter(adapterInvoice);

        if(invoices.size() > 0) {
            adapterInvoice.notifyDataSetChanged();
        }
        // return (RelativeLayout)inflater.inflate(R.layout.tab_layout_a, container, false);

    }

    private ArrayList<InvoicesData> gerarDados(){
        ArrayList<InvoicesData> invoices = new ArrayList<InvoicesData>();
        //Date date = new Date();
        //String stringDate = DateFormat.getDateTimeInstance().format(date);

        String hh = getFormattedDate();

        invoices.add(inserirDados("Fazendinha Night Club", 12566, hh)); //arrumar para acessar os dados no banco
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        invoices.add(inserirDados("Hipermercado Extra", 322, hh));
        return invoices;
    }

    private InvoicesData inserirDados(String nome, Integer valor, String horario){
        InvoicesData invoices = new InvoicesData(nome, valor, horario);
        return invoices;
    }

    public static String getFormattedDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(); //called without pattern
        return df.format(c.getTime());
    }
}
