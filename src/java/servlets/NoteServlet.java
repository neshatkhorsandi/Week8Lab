/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

/**
 *
 * @author
 */
public class NoteServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        NoteService ns = new NoteService();
        List<Note> list = ns.getAll();
        String edit = request.getParameter("edit");

        request.setAttribute("notesItems", list);

        if (edit != null)
        {
            Note note = ns.get(Integer.valueOf(edit));
            request.setAttribute("note", note);
            request.setAttribute("option", "Edit");
            request.setAttribute("test", edit);
        }
        else
        {
            request.setAttribute("option", "Add");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        NoteService ns = new NoteService();
        String action = request.getParameter("choice");
        String title = request.getParameter("titleField");
        String contents = request.getParameter("textArea");
        String edit = request.getParameter("edit");

        try
        {
            switch (action)
            {
                case ("save"):
                    ns.update(Integer.valueOf(edit), title, contents);
                    break;

                case ("add"):
                    ns.insert(title, contents);
                    break;

                case ("delete"):
                    ns.delete(Integer.valueOf(edit));
                    break;
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }

        response.sendRedirect("notes");
    }

}
