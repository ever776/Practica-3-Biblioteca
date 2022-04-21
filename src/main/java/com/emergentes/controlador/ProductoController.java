
package com.emergentes.controlador;

import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = (request.getParameter("op").equals("")) ? "listar" : request.getParameter("op");
        Libro lib = new Libro();
        int id;
        
        HttpSession ses = request.getSession();
        List<Libro> lista = (List<Libro>)ses.getAttribute("biblioteca");
        List<Categoria> categorias = (List<Categoria>)ses.getAttribute("cates");
        
        switch (op) {
            case "nuevo":
                if (lista.size() == 0) {
                    lib.setId(1);
                } else {
                    lib.setId(lista.get(lista.size()-1).getId()+1);
                }
                request.setAttribute("categorias", categorias);
                request.setAttribute("lib", lib);
                request.setAttribute("tipo", "new");
                request.getRequestDispatcher("producto-edit.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                lib = lista.get(posNodoProducto(id, request));
                request.setAttribute("categorias", categorias);
                request.setAttribute("lib", lib);
                request.setAttribute("tipo", "edit");
                request.getRequestDispatcher("producto-edit.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                int pos = posNodoProducto(id, request);
                lista.remove(pos);
                response.sendRedirect("libros.jsp");
                break;
            case "listar":
                request.setAttribute("biblioteca", lista);
                response.sendRedirect("libros.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String Disponible = request.getParameter("disponible");
        int idcat = Integer.parseInt(request.getParameter("idcat"));
        Categoria cate = nodoCategoria(idcat, request);
        
        String tipo = request.getParameter("tipo");
        
        Libro l = new Libro();
        l.setId(id);
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setDisponible(Disponible);
        l.setCate(cate);
        
        HttpSession ses = request.getSession();
        List<Libro> biblioteca = (List<Libro>)ses.getAttribute("biblioteca");
        
        if (tipo.equals("new")) {
            biblioteca.add(l);
        }else{
            biblioteca.set(posNodoProducto(id, request),l);
        }
        response.sendRedirect("libros.jsp");
        
    }
    
    public int posNodoProducto(int id,HttpServletRequest request){
        int index = -1;
        
        HttpSession ses = request.getSession();
        List<Libro> lista = (List<Libro>)ses.getAttribute("biblioteca");
        for(int i = 0; i < lista.size();i++){
            if (lista.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int posNodoCategoria(int id, HttpServletRequest request){
        int index = -1;
        
        HttpSession ses = request.getSession();
        List<Categoria> lista = (List<Categoria>)ses.getAttribute("cates");
        for(int i = 0; i < lista.size();i++){
            if (lista.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public Categoria nodoCategoria(int id, HttpServletRequest request){
        Categoria aux = new Categoria();
        HttpSession ses = request.getSession();
        List<Categoria> lista = (List<Categoria>)ses.getAttribute("cates");
        for(Categoria obj : lista){
            if (obj.getId() == id) {
                aux = obj;
            }
        }
        return aux;
    }

}
