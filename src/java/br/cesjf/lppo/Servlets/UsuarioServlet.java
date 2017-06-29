/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.Servlets;

import br.cesjf.lppo.Usuario;
import br.cesjf.lppo.dao.UsuarioJpaController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/criar.html", "/listar.html", "/editar.html", "/excluir.html"})
public class UsuarioServlet extends HttpServlet {

    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if(request.getServletPath().contains("/excluir.html")){
            doExcluirGet(request, response);
             response.sendRedirect("listar.html");
        }else if(request.getServletPath().contains("/editar.html")){
            doEditarGet(request, response);
        }else if(request.getServletPath().contains("/listar.html")){
            doListarGet(request, response);
        }else if(request.getServletPath().contains("/criar.html")){
            doCriarGet(request, response);
        }   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if (request.getServletPath().contains("/editar.html")) {;
            doEditarPost(request, response);
        }
        
        if(request.getServletPath().contains("/criar.html")) {
            doCriarPost(request, response);
        } 
        
    }
    
    private void doCriarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            request.getRequestDispatcher("criar_usuario.jsp").forward(request, response);
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response){
        
        Usuario us = new Usuario();
        us.setNome_completo(request.getParameter("nome_completo"));
        us.setEmail(request.getParameter("email"));
        us.setSenha(request.getParameter("senha"));

        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        
        try{
            dao.create(us);
            response.sendRedirect("listar.html");
        }catch(Exception ex){
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void doListarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
        usuarios = dao.findUsuarioEntities();
        
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("listar_usuario.jsp").forward(request, response);
    }
    
    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
        try{
            
            UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            Usuario us = dao.findUsuario(id);
            request.setAttribute("usuario", us);
            request.getRequestDispatcher("editar_usuario.jsp").forward(request, response);
        }catch(Exception e){
            response.sendRedirect("listar.html");

        }
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        try{
            
            UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            Usuario us = dao.findUsuario(id);
            
            us.setNome_completo(request.getParameter("nome_completo"));
            us.setEmail(request.getParameter("email"));
            us.setSenha(request.getParameter("senha"));
            dao.edit(us);
            
            response.sendRedirect("listar.html");
        }catch(Exception e){
            response.sendRedirect("listar.html");
        }
    }
    
    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        try{
            
            UsuarioJpaController dao = new UsuarioJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        }catch(Exception ex){
            response.sendRedirect("listar.html");
        }
    }
}
