package com.marcosvaldi.noteapp.model;

// CLASE: LO HEMOS CREADO con la EXTENSIÓN .model y por eso está dentro de un model


public class Note {

    //vbles: datos privados para tenerlos controlados

    private String title;
    private String text;
    private long color;

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
