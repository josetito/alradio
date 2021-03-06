package com.itcr.alradio;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jrarguedas on 07/01/17.
 */

public class Buscador extends Activity {
    List<String> filtroRadios;
    List<String> todasRadios;


    public boolean buscador(MenuInflater inflater, Menu menu, final Context context, final List<String> radios, final RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {

        inflater.inflate(R.menu.home_search_bar, menu);
        todasRadios = radios;
        filtroRadios = new ArrayList<>();

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
                if  (newText.toString().equals("")){
                    recyclerView.swapAdapter(new RecyclerViewAdapter(radios), false);
                }
                else {
                    searchItem(newText.toString().toLowerCase(), todasRadios, recyclerView);
                }
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void searchItem(String textToSearch,List<String> todasRadios,RecyclerView recyclerView){

        for(String radio:todasRadios) {
            if (radio.toLowerCase().contains(textToSearch)) {
                if (!filtroRadios.contains(radio)) {
                    filtroRadios.add(radio);
                }
            }
        }

        for(int i = 0; i < filtroRadios.size(); i++){
            System.out.println(i);
            if(!filtroRadios.get(i).toLowerCase().contains(textToSearch)){
                if (!filtroRadios.isEmpty()){
                    filtroRadios.remove(i);
                    i--;
                }
            }
        }

        recyclerView.swapAdapter(new RecyclerViewAdapter(filtroRadios), false);

    }

}