/*Aqui eu irei fazer o login do usuario conforme usuarios cadastrados no servidor, esse processo ainda não foi aprovado
* por falta de verba.*/

package br.senac.es.helpdeskrennan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import br.senac.es.helpdeskrennan.API.LoginTask;
import br.senac.es.helpdeskrennan.API.OnEventListener;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nome = (EditText) findViewById(R.id.txtNomeRn);
        final EditText sennha = (EditText) findViewById(R.id.txtSenhaRn);
        final Button botaoLofar = (Button) findViewById(R.id.botaoLogarRn);


        botaoLofar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginTask loginTask = new LoginTask(view.getContext(), new OnEventListener<String>() {
                    @Override

                    public void onSuccess(String object) {
                        Gson gson = new Gson();


                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
            }
        });


//


    }


}
