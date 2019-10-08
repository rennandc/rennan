package br.senac.es.helpdeskrennan;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;


import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


import br.senac.es.helpdeskrennan.API.LoginTask;
import br.senac.es.helpdeskrennan.API.OnEventListener;
import br.senac.es.helpdeskrennan.model.Usuario;

public class MainActivity extends AppCompatActivity {
    List listaDeUsuariosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Usuario> listaDeusuarios = new ArrayList<Usuario>();


        final EditText login = (EditText) findViewById(R.id.txtNomeRn);
        final EditText senha = (EditText) findViewById(R.id.txtSenhaRn);
        final Button logar = (Button) findViewById(R.id.botaoLogarRn);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginTask loginTask = new LoginTask(getApplicationContext(), new OnEventListener<String>() {
                    @Override
                    public void onSuccess(String result) {
//                        Gson gson = new Gson();
//                        Usuario[] usuarios = gson.fromJson(result, Usuario[].class);

                        for (Usuario usuario : listaDeusuarios) {
                            if (usuario.getLogin().equals(login.getText().toString()) && usuario.getPassword().equals(senha.getText().toString())) {
                                Toast.makeText(getApplicationContext(), "CORRETO", Toast.LENGTH_LONG).show();

                            }
                        }


                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getApplicationContext(), "FALHA", Toast.LENGTH_LONG).show();

                    }
                });


            }
        });


    }

}


