package com.marcosvaldi.noteapp.model;

// CLASE: LO HEMOS CREADO con la EXTENSIÓN .model y por eso está dentro de un model


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject{ // tengo que extenderlo de Realm para grabar en Realm

    //vbles: datos privados para tenerlos controlados

   @PrimaryKey private String title; // clave primaria para Realm
    private String text;
    private long color;

    // constructor vacío para Realm
    public Note(){

    }

    //creo un CONSTRUCTOR al que le paso un título
    public Note (String title){
        this.title = title; // para guardar el valor del título
    }


    //meto los getters y setters pq he creado las vlbes privadas (get lee,set los pone)

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }
}
