package com.marcosvaldi.noteapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteDetailFragment extends Fragment {


    //tengo que usar los EditText
    EditText titleText;
    EditText descriptionText;



    public NoteDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // TENGO QUE PONER COMO VBLE EL VIEW para poder hacer el findViewById (haciendo 2º botón-refactor-extract-variable-y escojo View)
        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);

        //los fragmentos no tienen en sí la función findViewById, entonces hay que usar view. y entonces ya sale el findViewById (por eso hemos hecho lo de la vble View)

        titleText= (EditText) view.findViewById(R.id.fragment_note_detail_title_text);
        descriptionText = (EditText) view.findViewById(R.id.fragment_note_detail_description_text);

        return view;
    }


    //--------VAMOS A HACER Q AL GIRAR LA PANTALLA NO SE BORRE LO QUE HE ESCRITO

    //en Pause tengo que grabar lo que hay en pantalla
    @Override
    public void onPause() {
        super.onPause();
        //grabar todos los datos a disco - me creo un Método con alt+intro: Método para cargar los datos del disco ocn alt+intro (primero pongo el nombre del método con () y le doy alt+intro para crear el métofo)
        saveAllToDisk();
    }

    //MÉTODO PARA SALVAR (sale al haber hecho alt+intro)
    private void saveAllToDisk() {

        // abro el fichero para escribot-me tengo que abrir un editor

        //me da un acceso de sólo lectura (getters y no setters) al fichero
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        //necesito un editor para grabar (aquí consigo los setters)
        SharedPreferences.Editor editor = preferences.edit();

        //leo lo que has escrito en pantalla (tengo q sacar lo q hay escrito de titleText y descriptionText)
        String title = titleText.getText().toString(); // se hace el toString para q me devuelva un String y no un editable

        String description = descriptionText.getText().toString(); // se hace el toString para q me devuelva un String y no un editable

        // grabo eso en el fichero
        editor.putString("NOTE_TITLE",title); // HAY QUE USAR LA MISMA CLAVE (NOTE_TITLE)
        editor.putString("NOTE_DESCRIPTION",description); // HAY QUE USAR LA MISMA CLAVE (NOTE_DESCRIPTION)

        editor.apply(); // graba los cambios lanzando una tarea en 2º plano y no t bloquea el hilo principal
    }

    // se dispara siempre que se cambia de pantalla (load data to show on screen (if any, si hay algo que leer))
    @Override
    public void onResume() {
        super.onResume();
        //Método para cargar los datos del disco ocn alt+intro (primero pongo el nombre del método con () y le doy alt+intro para crear el métofo)
        loadAllDataFromDisk();
    }

    //los fragmentos siempre llaman a los DESTROY, y es el que usamos para borrar las cosas cuando se cierre la nota que se había escrito
    @Override
    public void onDestroy() {
        super.onDestroy();


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        //he leído eso del fichero,lo he pintado y ahora quiero que lo borres
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("NOTE_TITLE");
        editor.remove("NOTE_DESCRIPTION");
        editor.apply();
    }

    //MÉTODO PARA CARGAR (sale al haber hecho alt+intro)
    private void loadAllDataFromDisk() {

        //cargo el fichero
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());


        // cojo las cosas del fichero
        String noteTitle = preferences.getString("NOTE_TITLE", ""); //lee del fichero de disco preferences y si contiene algo pone NOTE_TITLE y sino ""
        String noteDescription = preferences.getString("NOTE_DESCRIPTION", "");

        // cuando tengo que cargar las cosas de disco,las cojo y las pinto en pantalla
        titleText.setText(noteTitle);
        descriptionText.setText(noteDescription);



    }

}
