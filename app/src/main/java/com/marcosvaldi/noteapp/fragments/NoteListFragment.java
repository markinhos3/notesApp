package com.marcosvaldi.noteapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcosvaldi.noteapp.R;
import com.marcosvaldi.noteapp.adapters.NoteAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    //para OBTENER EL ACCESO AL RECYCLERVIEW
    private RecyclerView recyclerNotesView;

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        recyclerNotesView = (RecyclerView) view.findViewById(R.id.fragment_note_list_note_list);

        //hay que indicarle la forma en qué pintarlo (lista,grid,...); hay que pasarle un ayoutManager
        recyclerNotesView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void setAdapter(NoteAdapter adapter) {
        recyclerNotesView.setAdapter(adapter);
    }
}
