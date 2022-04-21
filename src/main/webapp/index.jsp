
<%@page import="com.emergentes.modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Libro"%>
<%
    if (session.getAttribute("biblioteca") == null) {
            ArrayList<Libro> lisaux = new ArrayList<Libro>();
            session.setAttribute("biblioteca", lisaux);
        }
    
    if (session.getAttribute("cates") == null) {
            ArrayList<Categoria> liscat = new ArrayList<Categoria>();
            
            liscat.add(new Categoria(1,"Novela"));
            liscat.add(new Categoria(2,"Historia"));
            liscat.add(new Categoria(3,"Cuento"));
            
            session.setAttribute("cates", liscat);
        }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
        <ul>
            <li><a href="libros.jsp" >Libros</a></li>
            <li><a href="categorias.jsp" >Categorías</a></li>
        </ul>    
    </body>
</html>
