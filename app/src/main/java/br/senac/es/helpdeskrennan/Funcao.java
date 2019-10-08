package br.senac.es.helpdeskrennan;


import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

class Funcao {


    public boolean verificarLogin(Context context, EditText nome, EditText senha){
        if (nome.getText().toString().equals("admin") && (senha.getText().toString().equals("admin"))) {
            Toast tost = Toast.makeText(context, "Login feito com sucesso", Toast.LENGTH_LONG);
            tost.show();


            return true;

        } else {
            Toast tost = Toast.makeText(context, "Login ou senha incorretos", Toast.LENGTH_LONG);
            tost.show();
            return false;
        }



    }



    }

