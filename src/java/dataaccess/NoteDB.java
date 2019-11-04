/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;

/**
 *
 * @author
 */
public class NoteDB
{

    public void insert(Note note) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().
                createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try
        {
            trans.begin();
            em.persist(note);
            trans.commit();
        }
        catch (Exception e)
        {
            trans.rollback();
        }
        finally
        {
            em.close();
        }

    }

    public void update(Note note)
    {
        EntityManager em = DBUtil.getEmFactory().
                createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try
        {
            trans.begin();
            em.merge(note);
            trans.commit();
        }
        catch (Exception E)
        {
            trans.rollback();
        }
        finally
        {
            em.close();
        }
    }

    public List<Note> getAll()
    {
        EntityManager em = DBUtil.getEmFactory()
                .createEntityManager();
        try
        {
            List<Note> notes = em.createNamedQuery("Note.findAll", Note.class)
                    .getResultList();
            return notes;
        }
        finally
        {
            em.close();
        }
    }

    public Note get(int noteid)
    {
        EntityManager em = DBUtil.getEmFactory()
                .createEntityManager();
        try
        {
            Note note = em.find(Note.class, noteid);
            return note;
        }
        finally
        {
            em.close();
        }
    }

    public void delete(Note note)
    {
        EntityManager em = DBUtil.getEmFactory()
                .createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try
        {
            trans.begin();
            em.remove(em.merge(note));
            trans.commit();
        }
        catch (Exception e)
        {
            trans.rollback();
        }
        finally
        {
            em.close();
        }
    }
}
