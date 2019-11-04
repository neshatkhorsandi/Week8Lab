/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.NoteDB;
import java.util.Date;
import java.util.List;
import models.Note;
/**
 *
 * @author
 */
public class NoteService
{
    public Note get(int noteid)
    {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        return note;
    }
    
    public List<Note> getAll()
    {
        NoteDB ndb = new NoteDB();
        List<Note> note = ndb.getAll();
        return note;
    }
    
    public void update(int noteid, String title, String contents) 
    {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        note.setNoteid(noteid);
        note.setTitle(title);
        note.setContents(contents);
        ndb.update(note);
    }
    
    public void delete(int noteid)
    {
        NoteDB ndb = new NoteDB();
        Note note = ndb.get(noteid);
        ndb.delete(note);
    }
    
    public void insert(String content, String title) throws Exception
    {
        NoteDB ndb = new NoteDB();
        Date date = new Date();
        Note note = new Note(0,date,title,content);
        ndb.insert(note);
    }
}
