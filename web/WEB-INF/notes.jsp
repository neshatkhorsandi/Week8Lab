<%-- 
    Document   : notes
    Created on : Nov 4, 2019, 9:30:32 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
    </head>
    <body>
        <h1>Notes!</h1>
        <table>
            <tr>
                <th width="300px">Date Created</th>
                <th width="200px">Title</th>
            </tr>
            <c:forEach items="${notesItems}" var="note">
                <tr> 
                    <td>${note.datecreated}</td>
                    <td>${note.title}</td>
                    <td>
                        <form>
                            <input type="submit" value="Edit"> 
                            <input type="hidden" name="edit" value="${note.noteid}">
                        </form>
                    </td>
                </tr>
            </c:forEach>             
        </table>

        <c:if test="${option eq 'Add'}">
            <h2>Add Note</h2>
            <form action="notes" method="post">
                <input type="text" placeholder="title" name="titleField" value="${note.title}"><br>
                <textarea rows="12" cols="50" name="textArea">${note.contents}</textarea><br>
                <input type="submit" value="Add">
                <input type="hidden" name="choice" value="add">
            </form>
        </c:if>
        <c:if test="${option eq 'Edit'}">
            <h2>Edit Note</h2>
            <form method="post" action="notes">
                <input type="submit" value="Delete">
                <input type="hidden" name="choice" value="delete">
                <input type="hidden" name="edit" value="${note.noteid}">
            </form>  
            <form method="post" action="notes">    
                <input type="text" name="titleField" value="${note.title}"><br>
                 <textarea rows="12" cols="50" name="textArea">${note.contents}</textarea><br>
                <input type="submit" value="Save">
                <input type="hidden" name="choice" value="save">
                <input type="hidden" name="edit" value="${note.noteid}">
            </form>
        </c:if>

    </body>
</html>
