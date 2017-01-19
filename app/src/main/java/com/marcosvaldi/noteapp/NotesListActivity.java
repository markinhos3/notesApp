package com.marcosvaldi.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.marcosvaldi.noteapp.model.Note;
import com.marcosvaldi.noteapp.model.Notes;

public class NotesListActivity extends AppCompatActivity {

    // creamos una LISTA DE NOTAS
    Notes listOfNotes = new Notes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        NoteListFragment noteListFragment = (NoteListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_note_list);

        //rellenamos la LISTA de notas
        for (int i = 0; i < 20; i++) {
            Note note = new Note("Note" + i);
            note.setText("ATTENTION: " + i);
            listOfNotes.add(note);

        }


        //me CREO EL ADAPTADOR y ahy que pasarle una lista de notas y un contexto
        NoteAdapter adapter = new NoteAdapter(listOfNotes, this);
        //necesito por último CONECTAR EL ADAPTADOR CON LA LISTA (pasándoselo a la lista que está dentro del fragmento):
        noteListFragment.setAdapter(adapter); // alt+intro para crear el método

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

            Intent i = new Intent(NotesListActivity.this,NoteDetailActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
