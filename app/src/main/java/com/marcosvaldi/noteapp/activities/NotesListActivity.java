package com.marcosvaldi.noteapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.marcosvaldi.noteapp.R;
import com.marcosvaldi.noteapp.adapters.NoteAdapter;
import com.marcosvaldi.noteapp.fragments.NoteListFragment;
import com.marcosvaldi.noteapp.model.Note;
import com.marcosvaldi.noteapp.model.Notes;

import io.realm.Realm;
import io.realm.RealmResults;

public class NotesListActivity extends AppCompatActivity {

    private static final int NEW_NOTE = 25;

    // creamos una LISTA DE NOTAS
    Notes listOfNotes = new Notes();

    // vble de instancia que necesita el Adaptador que le paso a REalm
    NoteListFragment noteListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        noteListFragment = (NoteListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_note_list);

        /*//rellenamos la LISTA de notas
        for (int i = 0; i < 20; i++) {
            Note note = new Note("Note" + UUID.randomUUID() + i);
            note.setText("ATTENTION: " + i);
            listOfNotes.add(note);

        }*/

        // llamo a cargar Realm
        loadFromRealm();

        //me CREO EL ADAPTADOR y ahy que pasarle una lista de notas y un contexto
        NoteAdapter adapter = new NoteAdapter(listOfNotes, this);
        //necesito por último CONECTAR EL ADAPTADOR CON LA LISTA (pasándoselo a la lista que está dentro del fragmento):
        noteListFragment.setAdapter(adapter); // alt+intro para crear el método

    }

    // necesito crear mi método onPause
    @Override
    protected void onPause() {
        super.onPause();

        //aquí grabo Realm
        saveToReralm();
    }

    //método para GRABAR EN REALM
    private void saveToReralm(){
        Realm realm = Realm.getDefaultInstance();

        //hago la TRANSACCIÓN
        //abro transacción
        realm.beginTransaction();
        //grabo con el fori
        for (int i = 0; i < listOfNotes.count() ; i++) {
            Note n = listOfNotes.get(i);
            realm.copyToRealmOrUpdate(n);
        }

        // cierro transacción
        realm.commitTransaction();
    }

    //método para CARGAR DESDE REALM
    private void loadFromRealm(){
        Realm realm = Realm.getDefaultInstance();

        //para devolver tdo uso findAll
        RealmResults<Note> results = realm.where(Note.class).findAll();

        listOfNotes = new Notes();
        //uso bucle for each pq mis RealmResults sí están preparados para eso
        for (Note n: results){
            listOfNotes.add(n);
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
            startActivityForResult(i, NEW_NOTE);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // necesito crearme el método onActivityResult debido al startForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //para sacar la nueva nota
        if (requestCode == NEW_NOTE && resultCode == RESULT_OK){
            final Note newNote = (Note) data.getSerializableExtra("NewNote"); // RealmObject es Serializable, y tb hay que castearlo con alt+intro

            // AÑADIRLO A LA BASE DE DATOS
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() { // otra forma de hacer la transacción y nos evita el begin y el commit
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(newNote);
                }
            });

            //me aprovecho del método loadFromRealm
            loadFromRealm();
        }
    }
}
