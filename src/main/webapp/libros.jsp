

<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Libro"%>
<%
    List<Libro> libros = (List<Libro>)session.getAttribute("biblioteca");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Libros</h1>
        <p><a href="ProductoController?op=nuevo" >Nuevo</a></p>
        <table border="1"> 
            <tr>
                <th>Id</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoría</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (libros != null) {
                        for(Libro item : libros){
                    
            %>
            
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getTitulo() %></td>
                <td><%= item.getAutor() %></td>
                <td><%= item.getDisponible() %></td>
                <td><%= item.getCate().getCategoria() %></td>
                <td><a href="ProductoController?op=editar&id=<%= item.getId() %>"  >Editar</a></td>
                <td><a href="ProductoController?op=eliminar&id=<%= item.getId() %>"  >Eliminar</a></td>
            </tr>            
            <%
                        }
                    }
            %>
        </table>
        <p><a href="index.jsp" >Ir al Inicio</a></p>
    </body>
</html>
