package br.senac.es.helpdeskrennan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.senac.es.helpdeskrennan.model.Mensagem;
import br.senac.es.helpdeskrennan.model.Status;


public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listaDeChamadosTela = (ListView) findViewById(R.id.listaRn);
        List<Mensagem> listaMensagem = new ArrayList<Mensagem>();

        Mensagem novaMensagem1 = new Mensagem(1L, "rennan", Status.ENVIADA);
        Mensagem novaMensagem2 = new Mensagem(2L, "Coquinha", Status.NAOENVIADA);
        Mensagem novaMensagem3 = new Mensagem(3L, "Luiz", Status.ENVIADA);
        Mensagem novaMensagem4 = new Mensagem(4L, "Zemerson", Status.ENVIADA);
        Mensagem novaMensagem5 = new Mensagem(5L, "Professor", Status.NAOENVIADA);
        Mensagem novaMensagem6 = new Mensagem(6L, "Thiaguinho", Status.NAOENVIADA);
        listaMensagem.add(novaMensagem1);
        listaMensagem.add(novaMensagem2);
        listaMensagem.add(novaMensagem3);
        listaMensagem.add(novaMensagem4);
        listaMensagem.add(novaMensagem5);
        listaMensagem.add(novaMensagem6);
        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(this,android.R.layout.simple_list_item_1,listaMensagem);
        listaDeChamadosTela.setAdapter(adapter);



//


    }


}
