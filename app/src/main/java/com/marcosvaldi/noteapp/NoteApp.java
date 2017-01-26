package com.marcosvaldi.noteapp;

import android.app.Application;

import io.realm.Realm;


public class NoteApp extends Application {

    // creo el método onCreate
    @Override
    public void onCreate() {
        super.onCreate();

        // iniciar REALM
        Realm.init(getApplicationContext());
    }
}
