/*Aqui faço basicamente a mesma coisa do chamados abertos, as únicar diferenças são os id e o xml também é diferente,
* e aqui eu faço a verificação se os chamados são fechados antes de adciona-los na lista*/
package br.senac.es.helpdeskrennan;

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


public class TabelaDosChamadosFechados extends Fragment {
    ListView listChamadosFechados;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View viewFragmente = inflater.inflate(R.layout.teladoschamadosabertos, container, false);


        final FloatingActionButton botaoAtualizar = (FloatingActionButton) viewFragmente.findViewById(R.id.botaoRn);
        atualizarChamados(viewFragmente);


        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarChamados(viewFragmente);

            }
        });
        return viewFragmente;
    }

    private void atualizarChamados(final View viewMetodo) {
        final List<Chamados> lista = new ArrayList<Chamados>();
        ChamadoTask chamadoTask = new ChamadoTask(viewMetodo.getContext(), new OnEventListener<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Chamados[] chamados = gson.fromJson(result, Chamados[].class);

                for (Chamados chamado : chamados) {
                    if (chamado.getStatus() != null) {
                        if (chamado.getStatus().toLowerCase().equals("fechado")) {
                            lista.add(chamado);

                        }


                    }

                }
                ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(), android.R.layout.simple_list_item_1, lista);
                listChamadosFechados = (ListView) viewMetodo.findViewById(R.id.lista);
                listChamadosFechados.setAdapter(adapter);

            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(viewMetodo.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        chamadoTask.execute();
    }
}
