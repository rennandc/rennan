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
        final View view = inflater.inflate(R.layout.teladoschamadosabertos, container, false);

        final List<Chamados> listaDeChamadosAbertos = new ArrayList<Chamados>();

        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "CHAMADOS: ", Toast.LENGTH_LONG).show();
//                Log.e("JSON",result);
                Gson gson = new Gson();

                Chamados[] chamados = gson.fromJson(result, Chamados[].class);

                for (Chamados chamado : chamados) {


                    if (listaDeChamadosAbertos == null) {
                        Intent intent = new Intent(getActivity(), NovoChamadoActivity.class);
                        startActivity(intent);
                    }

                    if (chamado.getStatus().toLowerCase().equals("aberto")) {

                        listaDeChamadosAbertos.add(chamado);
                    }
                    ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(), android.R.layout.simple_list_item_1, listaDeChamadosAbertos);


                    listChamadosAbertos = (ListView) view.findViewById(R.id.lista);
                    listChamadosAbertos.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        chamadoTask.execute();
        return view;
    }
}