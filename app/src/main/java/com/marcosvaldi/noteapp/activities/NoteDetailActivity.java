package com.marcosvaldi.noteapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marcosvaldi.noteapp.R;
import com.marcosvaldi.noteapp.fragments.NoteDetailFragment;
import com.marcosvaldi.noteapp.model.Note;

import java.io.Serializable;

public class NoteDetailActivity extends AppCompatActivity {

    Button saveButton;
    //tengo que declarar la vble del fragmento y su tipo lo miro en activity_note_detail
    NoteDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        // CAPTURAR el FRAGMENTO (siempre usar getSupportFragmentManager() pq es quien soporta a
        // las versiones antiguas de Android ) como hago con un botón,un texto,..
        detailFragment = (NoteDetailFragment) getSupportFragmentManager().findFragmentById(R.id.activity_note_detail___detail_fragment);

        // capturo el BOTÓN SAVE
        saveButton = (Button) findViewById(R.id.activity_note_detail___close_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // tendré que colocar la nota que he escrito -> me la tengo que crear y devolverla por aquí con un Intent
                Intent retunrIntent = new Intent();
                // aquí me creo la nota
                Note note = detailFragment.getNote(); // me gustaría que este me de la nota que está escrita -> me tengo que crear ese método con alt+intro (create method)
                // la enchufamos dentro del retunrIntent los datos que queremos devolver
                retunrIntent.putExtra("NewNote", (Serializable) note); // le colocamos: una clave (usamos la de NotesListActivity); un Serializable que es note y se hace un cast con alt+intro ( y no PArcelable que se usa cuando se pasan muuchos objetos de una lista a otra)

                // cuando hay un Serializable se hace el setResult para establecer si ha ido bien o mal
                setResult(RESULT_OK, retunrIntent);
                // se cerrará seguro al darle al botón, esto se declara lo primero
                finish();
            }
        });
    }

    // me puedo crear un método para trabajar con el fragmento -> necesito una REFERENCIA para trabajar con ese fragmento -> tengo que acceder al FragmentManager
}
