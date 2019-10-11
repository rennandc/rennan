/*
* Aqui é a tela onde iremos abrir um novo chamado.
* */

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

import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        //Aqui eu ligo a classe ao xml activity_msg_nova.
        setContentView(R.layout.activity_msg_nova);
        //Pegando o id da caixa de mensagens que está no xml.
        final EditText escreverMsg = (EditText) findViewById(R.id.msgRn);
        //Pegando o botao enviar que está no xml.
        Button botaoEnviarMsg = (Button) findViewById(R.id.enviarRn);

        //mAPIService para que o programa saiba onde ele fará o Post
        mAPIService = ApiUtils.getService();
        //OnClick do botao de enviar mensagem.
        botaoEnviarMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Varival que recebera o conteúdo que foi escrito na caixo de testo, convertido para String.
                String mensagem = escreverMsg.getText().toString().trim();
                //Iniciando um novo objeto da classe Chamado  (utilizando o construtor vazio que criamos)
                Chamados chamados = new Chamados();
                //Coloco em Descricao a variavel mensagem.
                chamados.setDecricao(mensagem);


                if (!TextUtils.isEmpty(mensagem)) {
                    //Chamando a função novoChamado passando como parâmetro o objeto chamados e a aplicação.
                    novoChamado(chamados, getApplicationContext());

                }



            }
        });
    }

//Função para criarmos um novo chamado.
    public void novoChamado(Chamados chamado, final Context context) {


        //Instanciando um novo formato de data para variável sdf.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //Iniciando um novo obejto dataEnvio da classe Date.
        Date dataEnvio = new Date();
        mAPIService = ApiUtils.getService();

        //Instanciando um Array de map's para que possa ser passado o esqueleto do novo chamado a ser aberto.
        Map<String, String> jsonParams = new ArrayMap<>();
        //Assim como no modelo os campos devem corresponder exatamente ao banco de dados, caso contrário os valores serão
        //nulos.
        //O Array espera receber dois campos em String então passamos o nome conforme servidor e qual atributo.
        //correspondente a ele no modelo de Chamados.
        jsonParams.put("descricao", chamado.getDecricao());
        jsonParams.put("status", Status.FECHADO.toString());
        jsonParams.put("dataAbertura", sdf.format(dataEnvio.getTime())+ "");


        /*
        * Essa parte em baixo ele está tentando se comunincar com o servidor.
        * */
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());

        Call<ResponseBody> response = mAPIService.salvarChamado(body);

        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                /*Caso a abertura do chamado dê certo ele irá mostrar a mensagem abaixo na tela e irá para a tela TabssActivity
                * onde se encontra os nossos fragmentos de chamados abertos e fechados*/
                try {
                    Toast.makeText(context, "Chamado aberto com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NovoChamadoActivity.this, TabssActivity.class);
                    startActivity(intent);
                }
                //Caso dê errado ele exibirá o erro
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                // other stuff...
                //Se a abertura do chamado falhar ele exibira a mensagem abaixo.
                Toast.makeText(context, "A abertura do chamado falhou!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
