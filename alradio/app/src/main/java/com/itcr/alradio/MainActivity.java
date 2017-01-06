package com.itcr.alradio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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


        //Buscador
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.buscador, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getText(R.string.search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, R.string.submitted, Toast.LENGTH_SHORT).show();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textView.setText(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            // Handle the camera action
        } else if (id == R.id.nav_mis_listas) {
            popUpAgregarLista();

        } else if (id == R.id.nav_reproductor) {
            popUpAgregarEmisora();

        } else if (id == R.id.nav_salir) {
            //finish();
            popUpSalir();

        } else if (id == R.id.nav_acerca_de) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void popUpSalir(){
        AlertDialog.Builder salirApp = new AlertDialog.Builder(this);
        salirApp.setTitle("Salir");
        salirApp.setMessage("¿Estás seguro que deseas salir?");
        salirApp.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        salirApp.setNegativeButton("Cancelar", null);

        Dialog ejePopUp = salirApp.create();
        ejePopUp.show();
    }

    public void popUpAgregarLista(){
        AlertDialog.Builder agregarLista = new AlertDialog.Builder(this);
        agregarLista.setTitle("Nueva Lista");
        agregarLista.setMessage("Ingrese el nombre de la lista");
        final EditText ET_Nombre = new EditText(this);

        agregarLista.setView(ET_Nombre);

        agregarLista.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombreLista = ET_Nombre.getText().toString().trim();
                if (nombreLista.length() != 0){
                    Toast.makeText(MainActivity.this, "Nombre: " + nombreLista, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Ingrese un nombre", Toast.LENGTH_LONG).show();
                }
            }
        });

        agregarLista.setNegativeButton("Cancelar", null);

        Dialog ejePopUp = agregarLista.create();
        ejePopUp.show();
    }

    public void popUpAgregarEmisora() {
        String[] listaElementos = {"Selección 1", "Selección 2", "Selección 3"};
        List<String> list = new ArrayList<String>();
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");
        list.add("prueba");

        AlertDialog.Builder agregarEmisora = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.spinner, null);
        agregarEmisora.setTitle("Lista");

        Spinner spinner = (Spinner) mView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        agregarEmisora.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();
            }
        });

        agregarEmisora.setView(mView);
        //AlertDialog ejePopUp = agregarEmisora.create();
        //ejePopUp.show();
        agregarEmisora.show();
    }


}
