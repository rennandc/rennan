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
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

adapter = new TabAdapter(getSupportFragmentManager());
adapter.addFragment(new TabelaDosChamadosAbertos(),"ABERTOS");
//adapter.addFragment(new MainActivity(),"LOGIN");
adapter.addFragment(new TabelaDosChamadosFechados(),"FECHADAS");
viewPager.setAdapter(adapter);
tabLayout.setupWithViewPager(viewPager);

     Button novaMsg = (Button) findViewById(R.id.botaoNovaMsgRn);


     novaMsg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(TabssActivity.this, NovoChamadoActivity.class);
             startActivity(intent);
         }
     });


    }
}
