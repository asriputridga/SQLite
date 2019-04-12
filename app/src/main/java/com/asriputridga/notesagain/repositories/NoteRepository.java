package com.asriputridga.notesagain.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.asriputridga.notesagain.dao.NoteDao;
import com.asriputridga.notesagain.db.AppDatabase;
import com.asriputridga.notesagain.models.Note;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> notes;

    public NoteRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        noteDao = db.noteDao();
        notes = noteDao.getAll();
    }
    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void insert(Note note) {
    }

    public void update(Note note) {
    }

    private static class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao asyncTaskDao;
        private NoteDao noteDao;

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
        InsertAsyncTask(NoteDao dao) {
            asyncTaskDao = dao;
        }
        public void insert(Note note) {
            new InsertAsyncTask(noteDao)
                    .execute(note);
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<Note, Void, Void>{
        private NoteDao asyncTaskDao;
        private NoteDao noteDao;


        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
        UpdateAsyncTask(NoteDao dao) {
            asyncTaskDao = dao;
        }
        public void update(Note note) {
            new UpdateAsyncTask(noteDao)
                    .execute(note);
        }

    }
}
