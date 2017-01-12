package com.marcosvaldi.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class NotesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
    }

    //USO EL MÉTODO QUE ME CREA EL MENU: lo he copiado del proyecto Fragments y al no reconocer la función menu hay q darle a alt+enter y crear el manu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // SE PUEDEN CREAR CONDICIONES PARA MOSTRAR UNO U OTRO MENU QUE CREEMOS
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; // SI LO PONGO FALSE: me crea el menú pero no me lo muestra (si por ej no he cargado una lista de comida en el restaurante)
    }

    //para que el botón ADD haga algo tenemos que meterle el MÉTODO onOptionsItemSelected()
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_main_action_add_note) {

            Intent i = new Intent(NotesListActivity.this,NotesListActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
