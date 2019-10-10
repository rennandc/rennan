/*Tela onde mostrará os fragmento de chamados abertos e chamados fechados*/
package br.senac.es.helpdeskrennan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import br.senac.es.helpdeskrennan.model.NovoChamadoActivity;


public class TabssActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabss);
        //Pegando os id's da tela.
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//Criando um novo obejto adapter de TabAdapter.
adapter = new TabAdapter(getSupportFragmentManager());
//Aqui eu adciono no adapter o fragmento dos chamados aberto e fechado e passo também o que ficará escrito na tela.
adapter.addFragment(new TabelaDosChamadosAbertos(),"ABERTOS");
adapter.addFragment(new TabelaDosChamadosFechados(),"FECHADAS");
viewPager.setAdapter(adapter);
tabLayout.setupWithViewPager(viewPager);
//Aqui eu instancio o botao novaMsg passando o id botaoNovaMsgRn que se encontra no xml activity_tabss
     Button novaMsg = (Button) findViewById(R.id.botaoNovaMsgRn);


     //OnClick do boatao novaMsg.
     novaMsg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             //Quando clicar ele trocará de página, irá até a classe NovoChamadoActivity.
             Intent intent = new Intent(TabssActivity.this, NovoChamadoActivity.class);
             startActivity(intent);
         }
     });


    }
}
