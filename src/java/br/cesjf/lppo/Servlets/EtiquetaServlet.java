package br.cesjf.lppo.Servlets;

import br.cesjf.lppo.Etiqueta;
import br.cesjf.lppo.dao.EtiquetaJpaController;
import br.cesjf.lppo.dao.TarefaJpaController;
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


@WebServlet(name = "EtiquetaServlet", urlPatterns = {"/criarEtiqueta.html", "/listarEtiqueta.html", "/editarEtiqueta.html", "/excluirEtiqueta.html", "/listarEtiquetaPorAutor.html", "/listarEtiquetaPorAutoreTitulo.html"})
public class EtiquetaServlet extends HttpServlet{

   @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         
        if(request.getServletPath().contains("/listarEtiquetaPorAutoreTitulo.html")){
            doListarEtiquetaPorAutoreTituloGet(request, response);
        }else if (request.getServletPath().contains("/listarEtiquetaPorAutor.html")){
            doListarEtiquetaPorAutorGet(request, response);
        }else if(request.getServletPath().contains("/excluirEtiqueta.html")){
            doExcluirGet(request, response);
            response.sendRedirect("listarEtiqueta.html");
        }else if(request.getServletPath().contains("/editarEtiqueta.html")){
            doEditarGet(request, response);
        }else if (request.getServletPath().contains("/listarEtiqueta.html")){
            doListarGet(request, response);
        }else if(request.getServletPath().contains("/criarEtiqueta.html")){
            doCriarGet(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if(request.getServletPath().contains("/editarEtiqueta.html")){
            doEditarPost(request, response);
        }
        
        if(request.getServletPath().contains("/criarEtiqueta.html")){
            doCriarPost(request, response);
        }
    }
    
    private void doCriarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("criar_etiqueta.jsp").forward(request, response);
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response){
        
        Etiqueta et = new Etiqueta();
        UsuarioJpaController us = new UsuarioJpaController(ut, emf);
        TarefaJpaController tf = new TarefaJpaController(ut, emf);
        
        et.setUsuario((us.findUsuario(Long.parseLong(request.getParameter("id_usuario")))));
        et.setTarefa((tf.findTarefa(Long.parseLong(request.getParameter("id_tarefa")))));
        et.setTitulo(request.getParameter("titulo"));

        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        
        try{
            dao.create(et);
            response.sendRedirect("listarEtiqueta.html");
        }catch(Exception ex){
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void doListarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<Etiqueta> etiquetas = new ArrayList<>();
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiquetas = dao.findEtiquetaEntities();

        request.setAttribute("etiquetas", etiquetas);
        request.getRequestDispatcher("listar_etiqueta.jsp").forward(request, response);
    }
    
    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        try{
            
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            Etiqueta et = dao.findEtiqueta(id);
            
            request.setAttribute("etiqueta", et);
            request.getRequestDispatcher("editar_etiqueta.jsp").forward(request, response);
        }catch(Exception e){
            response.sendRedirect("listarEtiqueta.html");
        }

    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try{

            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
            UsuarioJpaController us = new UsuarioJpaController(ut, emf);
            TarefaJpaController tf = new TarefaJpaController(ut, emf);
            
            Long id = Long.parseLong(request.getParameter("id"));
            Etiqueta et = dao.findEtiqueta(id);

            et.setUsuario((us.findUsuario(Long.parseLong(request.getParameter("id_usuario")))));
            et.setTarefa((tf.findTarefa(Long.parseLong(request.getParameter("id_tarefa")))));
            et.setTitulo(request.getParameter("titulo"));

            dao.edit(et);

            response.sendRedirect("listarEtiqueta.html");
        }catch(Exception e){
            response.sendRedirect("listarEtiqueta.html");
        }
    }
    
    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        try{
            
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
            
        }catch(Exception ex){
            response.sendRedirect("listarEtiqueta.html");
        }
    }
    
    private void doListarEtiquetaPorAutorGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Etiqueta> etiquetas = new ArrayList<>();
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiquetas = dao.findEtiquetaEntities();

        request.setAttribute("etiquetas", etiquetas);
        request.getRequestDispatcher("listar_etiqueta_autor.jsp").forward(request, response);
    }
    
    private void doListarEtiquetaPorAutoreTituloGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Etiqueta> etiquetas = new ArrayList<>();
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiquetas = dao.findEtiquetaEntities();

        request.setAttribute("etiquetas", etiquetas);
        request.getRequestDispatcher("listar_etiqueta_autor_titulo.jsp").forward(request, response);
    }
}
