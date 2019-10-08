package br.senac.es.helpdeskrennan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


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
adapter.addFragment(new TabelaDosChamadosAbertos(),"ENVIADAS");
adapter.addFragment(new MainActivity(),"LOGIN");
adapter.addFragment(new TabelaDosChamadosFechados(),"FECHADAS");
viewPager.setAdapter(adapter);
tabLayout.setupWithViewPager(viewPager);


    }
}
