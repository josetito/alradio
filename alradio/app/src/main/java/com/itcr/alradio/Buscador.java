package com.itcr.alradio;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jrarguedas on 07/01/17.
 */

public class Buscador extends Activity {
 /*   ArrayAdapter<String> adapter;
    List<String> radios;
    List<String> radiosBuscadas;
    ListView listView;
*/
    public boolean buscador(MenuInflater inflater, Menu menu, final Context context) {


       // listView=(ListView)findViewById(R.id.listview);

        inflater.inflate(R.menu.buscador, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(context.getText(R.string.search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(context, R.string.submitted, Toast.LENGTH_SHORT).show();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               /* if (newText.toString().equals("")){
                    //resetea la lista
                    initList();
                    return true;
                }
                else{
                    searchItem(newText.toString().toLowerCase());
                    return true;
                }*/
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
/*
    public void searchItem(String textToSearch){

        for(String radio:radios) {

            if (radio.contains(textToSearch)) {
                if (!radiosBuscadas.contains(radio)) {
                    radiosBuscadas.add(radio);
                    //Toast.makeText(MainActivity.this, radio, Toast.LENGTH_SHORT).show();
                }
            }
        }

        for(int i = 0; i < radiosBuscadas.size(); i++){
            System.out.println(i);
            if(!radiosBuscadas.get(i).contains(textToSearch)){
                if (!radiosBuscadas.isEmpty()){
                    radiosBuscadas.remove(i);
                    i--;
                }
            }
        }

        adapter.notifyDataSetChanged();


    }


    public void initList(){
        //items=new String[]{"Radio1","Radio2","Tito","Jank","Denis","Costa rica","Pura vida"};
        radios = new ArrayList();
        radios.add("radio");
        radios.add("tito");
        radios.add("denis");
        radios.add("behold");
        radios.add("bend");
        radios.add("bet");
        radios.add("bear");
        radios.add("beat");
        radios.add("become");
        radios.add("begin");
        //listItems = new ArrayList<>(Arrays.asList(items));
        radiosBuscadas = new ArrayList<>();


        adapter=new ArrayAdapter<String>(this,R.layout.activity_buscador,radiosBuscadas);
        listView.setAdapter(adapter);
    }*/
}