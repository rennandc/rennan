/*Esse é o fragmento que mostra os chamados abertos na tela*/
package br.senac.es.helpdeskrennan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.senac.es.helpdeskrennan.API.ChamadoTask;
import br.senac.es.helpdeskrennan.API.OnEventListener;
import br.senac.es.helpdeskrennan.model.Chamados;
import br.senac.es.helpdeskrennan.model.NovoChamadoActivity;


public class TabelaDosChamadosAbertos extends Fragment {

    ListView listChamadosAbertos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Ligo o fragmento no xml desejado.
        final View viewFragmente = inflater.inflate(R.layout.teladoschamadosabertos, container, false);

        //Instancio o botaoAtualizar que se encontra no xml com o id de botaoRn
        final FloatingActionButton botaoAtualizar = (FloatingActionButton) viewFragmente.findViewById(R.id.botaoRn);
        atualizarChamados(viewFragmente);

        //Onclick do blotao atualizar.
        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Função atualizar chamados, argumento o fragmento utilizado.
                atualizarChamados(viewFragmente);

            }
        });
        return viewFragmente;
    }
//Função atualizar chamados
    private void atualizarChamados(final View viewMetodo) {
        //Lista de chamados com o nome de lista.
        final List<Chamados> lista = new ArrayList<Chamados>();
        //Iniciando a comunicação com o servidor.
        ChamadoTask chamadoTask = new ChamadoTask(viewMetodo.getContext(), new OnEventListener<String>() {
            @Override
            //Em caso de sucesso ao se comunicar com o servidor.
            public void onSuccess(String result) {
                //Geison é tipo uma formatação.
                Gson gson = new Gson();
                Chamados[] chamados = gson.fromJson(result, Chamados[].class);
                //Faço um for de chamados para pegar todos os chamados.
                for (Chamados chamado : chamados) {
                    //Verifico se são nulos, em caso de não serem realizo a operação abaixo.
                    if (chamado.getStatus() != null) {
                        //Pego o status por meio do get, faço ficar minusculo e verifico se é aberto.
                        if (chamado.getStatus().toLowerCase().equals("aberto")) {
                            //Caso seja eu coloco ele na nova lista que criei, lista.
                            lista.add(chamado);

                        }


                    }

                }
                //Crio um ArrayAdapter para dizer qual é o formatao que alista que que ir.
                ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(), android.R.layout.simple_list_item_1, lista);
                //Mostro na tela, onde o id lista é do xml dos chamados abertos
                listChamadosAbertos = (ListView) viewMetodo.findViewById(R.id.lista);
                //seto o adapter que criei a cima passando aquela lista onde somente estão os chamados abertos.
                listChamadosAbertos.setAdapter(adapter);

            }

            @Override
            public void onFailure(Exception e) {
                //Caso dê erro ele irá monstrar a mensagem "ERROR" + as mensagens de erro
                Toast.makeText(viewMetodo.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        chamadoTask.execute();
    }
}





