
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementarn;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Categorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CategoriaDAO categoria = new CategoriaDAOImplementarn();
        //Crear instancia de sesion se le da true para crear la sesion
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", categoria.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String parametro = request.getParameter("opcion");
        
        if (parametro.equals("crear")) {
            String pag = "/Vistas-Categorias/crearCategoria.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
            dispatcher.forward(request, response);
        }else if(parametro.equals("listar")){
            this.listaCategorias(request, response);
        
        }else if(parametro.equals("modificar")){
             int id_categoria = Integer.parseInt(request.getParameter("id"));
             String nom_categoria = request.getParameter("nombre_cat");
             int estado_categoria = Integer.parseInt(request.getParameter("estado_cat"));
             
             String pag = "/Vistas-Categorias/crearCategoria.jsp?id_c="+id_categoria+"&&nombre_c="+nom_categoria+"&&estado_c="+estado_categoria+"&&signal=1";
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
             dispatcher.forward(request, response);
        
        }else if(parametro.equals("eliminar")){
            int del_id = Integer.parseInt(request.getParameter("id"));
            CategoriaDAO catz = new CategoriaDAOImplementarn();
            catz.borrarCat(del_id);
            this.listaCategorias(request, response);
        }
        this.listaCategorias(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @param request
     * @param response
     * @return a String containing servlet description
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    /*
    Opcion al crear una nueva categoria
    
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
           
        Categoria categoria = new Categoria();
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        String nom_categoria = request.getParameter("txtNomCategoria");
        int estado_categoria = Integer.parseInt(request.getParameter("txtEstadoCategoria"));
    
        categoria.setId_categoria(id_categoria);
        categoria.setNom_categoria(nom_categoria);
        categoria.setEstado_categoria(estado_categoria);
        
        CategoriaDAO guardarCat = new CategoriaDAOImplementarn();
        guardarCat.guardarCat(categoria);
        
        this.listaCategorias(request, response);

    }
            
            
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
