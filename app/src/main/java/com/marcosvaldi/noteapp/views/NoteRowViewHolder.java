package com.marcosvaldi.noteapp.views;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.marcosvaldi.noteapp.R;
import com.marcosvaldi.noteapp.model.Note;

public class NoteRowViewHolder extends RecyclerView.ViewHolder{

    TextView noteTilteText;
    TextView noteTextText;

    //me creo una propiedad para pasar una nota
    private Note note;

    public NoteRowViewHolder(View itemView) {
        super(itemView);

        noteTilteText= (TextView) itemView.findViewById(R.id.row_note_note_title);
        noteTextText= (TextView) itemView.findViewById(R.id.row_note_note_text);


    }

    //métodos de note
    public Note getNote() {
        return note;
    }
    public void setNote(Note note) {
        this.note = note;
        //le paso lo que tenga la nota en su texto
        noteTilteText.setText(note.getTitle());
        noteTextText.setText(note.getText());
    }



}
