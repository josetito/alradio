package com.itcr.alradio;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeank on 06/01/17.
 */

public class PopUps extends AppCompatActivity {

    public void popUpSalir(Context context){
        AlertDialog.Builder salirApp = new AlertDialog.Builder(context);
        salirApp.setTitle("Salir");
        salirApp.setMessage("¿Estás seguro que deseas salir?");
        salirApp.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                System.exit(0);
            }
        });

        salirApp.setNegativeButton("Cancelar", null);


        salirApp.show();
    }

    public void popUpAgregarLista(final Context context){
        AlertDialog.Builder agregarLista = new AlertDialog.Builder(context);
        agregarLista.setTitle("Nueva Lista");
        agregarLista.setMessage("Ingrese el nombre de la lista");
        final EditText ET_Nombre = new EditText(context);

        agregarLista.setView(ET_Nombre);

        agregarLista.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombreLista = ET_Nombre.getText().toString().trim();
                if (nombreLista.length() != 0){
                    Toast.makeText(context, "Nombre: " + nombreLista, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(context, "Ingrese un nombre", Toast.LENGTH_LONG).show();
                }
            }
        });

        agregarLista.setNegativeButton("Cancelar", null);


        agregarLista.show();
    }

    public void popUpAgregarEmisora(final Context context) {
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

        AlertDialog.Builder agregarEmisora = new AlertDialog.Builder(context);
        LayoutInflater mInflater;
        View mView;
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.new_my_list_popup_spinner, null);
        //View mView = getLayoutInflater().inflate(R.layout.spinner, null);
        agregarEmisora.setTitle("Lista");

        Spinner spinner = (Spinner) mView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_dropdown_item,
                list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        agregarEmisora.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "ok", Toast.LENGTH_LONG).show();
            }
        });

        agregarEmisora.setNegativeButton("Cancelar", null);

        agregarEmisora.setView(mView);

        agregarEmisora.show();
    }

}
