package com.asriputridga.notesagain.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Query;

import com.asriputridga.notesagain.models.Note;

import java.util.List;

public interface NoteDao {
    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAll();
}
