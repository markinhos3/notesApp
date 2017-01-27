package com.marcosvaldi.noteapp.adapters;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcosvaldi.noteapp.views.NoteRowViewHolder;
import com.marcosvaldi.noteapp.R;
import com.marcosvaldi.noteapp.model.Note;
import com.marcosvaldi.noteapp.model.Notes;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteRowViewHolder> {


    //inyector de Dependencias usando un CONSTRUCTOR
    private Notes notes;

    // necesito crear
    private Activity initialActivity;
    private Class<Activity> finalActivity; // vble de clase class, en la que sólo admite que se le pase una actividad

    LayoutInflater inflater;

    public NoteAdapter(Notes notes, Context context){
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
    }

    public NoteAdapter(Context context, List<Note> notes) {

    }

    @Override
    public NoteRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // carga el diseño de la nota, leo el diseño y creo todos los controles en memoria
        View view = inflater.inflate(R.layout.row_note, parent, false);

        // construyo el viewHolder
        NoteRowViewHolder viewHolder = new NoteRowViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NoteRowViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.setNote(note);

    }

    @Override
    public int getItemCount() {
        return notes.count();
    }

    // método para pasarle la actividad (GETTER doble)
    public void configInitialAndFinalActivity (Activity initialActivity, Class<? extends Activity> finalActivity){

        this.initialActivity = initialActivity;
        this.finalActivity = (Class<Activity>) finalActivity;
    }


}
