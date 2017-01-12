package com.marcosvaldi.noteapp.model;

//QUIERO QUE TENGA UNA SERIE DE MÉTODOS: añadir,insertar,borrar,actualizar -> para ello me creo un INTERFAZ (tener una lista de métodos)

import java.util.LinkedList;
import java.util.List;

public class Notes implements Enumerable<Note>{ // con alt+ins le meto los métodos CONFIGURADOS COMO  PLANTILLAS -> donde había una T lo cambia por lo que le pase a Enumerable<>


    // CREO UNA LISTA DE NOTAS privada - la llamo noteList
    private List<Note> noteList = new LinkedList<>(); // le creamos un nuevo LinkedList (podríamos usar tb ArrayList)

    //métodos creados con el alt+ins
    @Override
    public int count() {
        return noteList.size(); // uso la función size
    }

    @Override
    public void add(Note element) {
        noteList.add(element);

    }

    @Override
    public void remove(int index) {
        noteList.remove(index); // borra metiéndole el index

    }

    @Override
    public void update(int index, Note newElement) {
        noteList.set(index, newElement); //le paso el índice y el nuevo elemento

    }

    @Override
    public List<Note> getAll() {
        return noteList; // retorna tod
    }

}
