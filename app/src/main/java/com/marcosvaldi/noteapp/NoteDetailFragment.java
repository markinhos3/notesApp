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
    }

    // se dispara siempre que se cambia de pantalla (load data to show on screen (if any, si hay algo que leer))
    @Override
    public void onResume() {
        super.onResume();

        //Método para cargar los datos del disco ocn alt+intro (primero pongo el nombre del método con () y le doy alt+intro para crear el métofo)
        loadAllDataFromDisk();

    }

    //MÉTODO PARA CARGAR (sale al haber hecho alt+intro)
    private void loadAllDataFromDisk() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String noteTitle = preferences.getString("NOTE_TITLE", ""); //lee del fichero de disco preferences y si contiene algo pone NOTE_TITLE y sino ""
        String noteDescription = preferences.getString("NOTE_DESCRIPTION", "");
    }

}
