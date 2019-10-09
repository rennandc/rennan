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


public class TabelaDosChamadosFechados extends Fragment {
    ListView listChamadosFechados;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
final View view = inflater.inflate(R.layout.teladoschamadosfechados, container, false);

        final List<Chamados> listaDeChamadosFechados = new ArrayList<Chamados>();

        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {
            @Override
            public void onSuccess(String result) {

//                Log.e("JSON",result);
                Gson gson = new Gson();

                Chamados[] chamados = gson.fromJson(result, Chamados[].class);


                if(listaDeChamadosFechados == null){
                    Intent intent = new Intent(getActivity(), NovoChamadoActivity.class);
                    startActivity(intent);
                }
                for (Chamados chamado: chamados){
                    if(chamado.getStatus().toLowerCase().equals("fechado")){

                        listaDeChamadosFechados.add(chamado);

                    }
                ArrayAdapter<Chamados> adapter = new ArrayAdapter<Chamados>(getActivity(),android.R.layout.simple_list_item_1, listaDeChamadosFechados);



                listChamadosFechados = (ListView) view.findViewById(R.id.lista2);
                listChamadosFechados.setAdapter(adapter);
            }


            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(),"ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        chamadoTask.execute();
        return view;
    }
}