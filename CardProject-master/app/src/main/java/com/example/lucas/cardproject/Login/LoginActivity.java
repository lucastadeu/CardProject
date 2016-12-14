package com.example.lucas.cardproject.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lucas.cardproject.MainActivity;
import com.example.lucas.cardproject.NavigationActivity;
import com.example.lucas.cardproject.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText cpfClient = null;
    EditText senhaCartao = null;
    Button btnLoginOk;
    HttpPost httppost = new HttpPost();
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this, NavigationActivity.class);

        cpfClient = (EditText) findViewById(R.id.etCPFCliente);
        senhaCartao = (EditText) findViewById(R.id.etSenhaCartao);
        btnLoginOk = (Button) findViewById(R.id.btLoginOk);

        //Verifica no BD se o numero do cartão e senha existem, se sim, inicia Main do app
        btnLoginOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String numCartaoStr = String.valueOf(cpfClient.getText().toString());
                final String senhaCartaoStr = String.valueOf((senhaCartao.getText().toString()));


                if(numCartaoStr.equals("") || senhaCartaoStr.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Campo vazio.", Toast.LENGTH_LONG).show();

                }
                else
                {
                    //new MyAsyncTask().execute(numCartaoStr, senhaCartaoStr);
                    if(numCartaoStr.equals("36700944821") || senhaCartaoStr.equals("133736"))

                        startActivity(intent);

                }

            }
        });
    }

    private class MyAsyncTask extends AsyncTask<String, Integer, String> {
        String numCartaoStr = String.valueOf(cpfClient.getText().toString());


        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub

            String s = postData(params);

            return s;
        }

        protected void onPostExecute(String result){
            //Log.d("on post ","on post execute");
            if(result.contains("Successful")){
                Toast.makeText(getApplicationContext(),"Logado com sucesso.", Toast.LENGTH_LONG).show();
                Intent loginIntent = new Intent();
                loginIntent.setClass(getApplicationContext(),MainActivity.class);
                loginIntent.putExtra("cpfUsuario", numCartaoStr);
                startActivity(loginIntent);

            }
            else if(result.contains("failed")){
                Toast.makeText(getApplicationContext(),"Não foi possível realizar o login. Por favor, verifique suas credenciais.", Toast.LENGTH_LONG).show();
            }
            else if(result.contains("failure")){

                Toast.makeText(getApplicationContext(),"Erro na conexão.", Toast.LENGTH_LONG).show();

            }
        }

        public String postData(String valueIWantToSend[]) {

            String origresponseText="";
            try {
                // Add your data...............
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("username",valueIWantToSend[0]));

                nameValuePairs.add(new BasicNameValuePair("password", valueIWantToSend[1]));

                HttpClient httpclient = new DefaultHttpClient();

                //httppost = new HttpPost("http://192.168.56.1:8080/ERPServlet/MyServlet");
                httppost = new HttpPost("http://localhost:8080");

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpclient.execute(httppost);

                origresponseText=readContent(response);

                httpclient.getConnectionManager().shutdown();
                System.out.println("Connection close");

            }

            catch (IOException e) {
                // TODO Auto-generated catch block
            }

            return origresponseText;



        }

        String readContent(HttpResponse response)
        {

            String text = "";
            InputStream in = null;


            try {
                in = response.getEntity().getContent();


                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();

                String line = null;

               /* while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                    InputStreamReader(instream, "UTF-8"), 8000);


                }*/
                in.close();
                text = sb.toString();

            }
            catch (IllegalStateException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                }catch (Exception ex) {
                }
            }


            return text;
    }



    }

}