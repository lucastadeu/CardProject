package com.example.lucas.cardproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class cardFaturaActivity extends AppCompatActivity {

    private List<Cartao> cartoes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_fatura);


        new DownloadJsonAsyncTask().execute("http://10.0.5.180:8080/samples/mock_pessoas");

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

//peguei da net, tem q substituir o url pelo nosso e testar
    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Cartao>> {
        ProgressDialog dialog;

        //Exibe pop-up indicando que está sendo feito o download do JSON
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //Acessa o serviço do JSON e retorna a lista de pessoas
        @Override
        protected List<Cartao> doInBackground(String... params) {
            String urlString = params[0];
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(urlString);
            try {
                HttpResponse response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String json = getStringFromInputStream(instream);
                    instream.close();
                    List<Cartao> pessoas = getPessoas(json);
                    return pessoas;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service", e);
            }
            return null;
        }


        //Depois de executada a chamada do serviço
        @Override
        protected void onPostExecute(List<Cartao> result) {
            super.onPostExecute(result);
            dialog.dismiss();
            if (result.size() > 0) {
                ListView lista = (ListView) findViewById(R.id.lista_cartao_fatura);
                final CartaoAdapter carAdap = new CartaoAdapter(cardFaturaActivity.this, R.layout.card_adapter, cartoes);
                lista.setAdapter(carAdap);
            } else {
            }
        }


        //tem que ver se funciona, ai eu arrumo

        //Retorna uma lista de pessoas com as informações retornadas do JSON
        private List<Cartao> getPessoas(String jsonString) {
            List<Cartao> pessoas = new ArrayList<Cartao>();
            try {
                JSONArray pessoasJson = new JSONArray(jsonString);
                JSONObject pessoa;

                for (int i = 0; i < pessoasJson.length(); i++) {
                    pessoa = new JSONObject(pessoasJson.getString(i));
                    Log.i("PESSOA ENCONTRADA: ",
                            "nome=" + pessoa.getString("nome"));

                    Cartao objetoPessoa = new Cartao();
                    objetoPessoa.setNome(pessoa.getString("nome"));
                    pessoas.add(objetoPessoa);
                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON", e);
            }
            return pessoas;
        }


        //Converte objeto InputStream para String
        private String getStringFromInputStream(InputStream is) {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        }

    }
}
