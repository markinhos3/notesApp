package com.marcosvaldi.noteapp.model;

// ES UNA LISTA DE MÉTODOS

//QUIERO TENER UN ENUMERABLE QUE PUEDA USARLO PARA MUCHAS APLICACIONES QUE NO SOLO DEVUELVA NOTAS

import java.util.List;

public interface Enumerable<T> { // T es para cosas GEÉRICAS; y dnd ponía Note/s lo cambiamos por la T

    //lista de métodos
    int count();
    void add(T element); //para pasarle una nota
    void remove (int index);
    void update (int index, T newElement);

    //LISTA que me devuelva todas las notas
    List<T> getAll();

}



/*
public interface Enumerable {

    //lista de métodos
    int count();
    void add(Note element); //para pasarle una nota
    void remove (int index);
    void update (int index, Note newElement);

    //LISTA que me devuelva todas las notas
    List<Note> getAll();


}
*/