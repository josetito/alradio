package com.itcr.alradio;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> radios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radios = new ArrayList<>();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////////////////////////////////////
        radios.add("rad 1");
        radios.add("red 2");
        radios.add("pao 3");
        ///////////////////////////////////////

        recyclerView = (RecyclerView) findViewById(R.id.list_container);
        recyclerView.setAdapter(new RecyclerViewAdapter(radios));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Buscador buscador = new Buscador();
        return buscador.buscador(getMenuInflater(),menu,this,radios,recyclerView,layoutManager);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        PopUps popUp = new PopUps();
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            int s = radios.size();
            if (s > 0) {
                s -= 1;
                radios.remove(s);
                recyclerView.removeViewAt(s);
                recyclerView.getAdapter().notifyItemRemoved(s);
                recyclerView.getAdapter().notifyItemRangeChanged(s, radios.size());
            }
        } else if (id == R.id.nav_mis_listas) {
            popUp.popUpAgregarLista(this);

        } else if (id == R.id.nav_reproductor) {
            popUp.popUpAgregarEmisora(this);

        } else if (id == R.id.nav_salir) {
            popUp.popUpSalir(this);

        } else if (id == R.id.nav_acerca_de) {
            radios.add("Nueva Emisora");
            recyclerView.getAdapter().notifyDataSetChanged();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
