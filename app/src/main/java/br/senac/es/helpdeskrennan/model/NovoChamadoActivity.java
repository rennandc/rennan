package br.senac.es.helpdeskrennan.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;

import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

import br.senac.es.helpdeskrennan.API.APIService;
import br.senac.es.helpdeskrennan.API.ApiUtils;
import br.senac.es.helpdeskrennan.R;
import br.senac.es.helpdeskrennan.TabssActivity;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class NovoChamadoActivity extends AppCompatActivity {

    private APIService mAPIService;
    private TextView mResponseTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_nova);
        final EditText escreverMsg = (EditText) findViewById(R.id.msgRn);
        Button botaoEnviarMsg = (Button)findViewById(R.id.enviarRn);

        mAPIService = ApiUtils.getService();

        botaoEnviarMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mensagem = escreverMsg.getText().toString().trim();

                if (!TextUtils.isEmpty(mensagem)) {
                    novoChamado(mensagem, getApplicationContext());

                }


            }
        });
    }


    public void novoChamado(Chamados chamado, final Context context) {

        Date dataEnvio = new Date();
        mAPIService = ApiUtils.getService();


        Map<String, String> jsonParams = new ArrayMap<>();
        jsonParams.put("descricao", chamado.getDecricao());
        jsonParams.put("status", chamado.getStatus());
        jsonParams.put("dataAbertura", dataEnvio.getTime()+"");


        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<ResponseBody> response = mAPIService.salvarChamado(body);

        response.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse)
            {
                try
                {
                    Toast.makeText(context, "Chamado aberto com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NovoChamadoActivity.this, TabssActivity.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable)
            {
                // other stuff...
                Toast.makeText(context, "A abertura do chamado falhou!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
