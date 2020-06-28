/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductoDAO;
import DAO.ProdcutoDAOImplementarn;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void listaProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductoDAO producto = new ProdcutoDAOImplementarn();
        //Crear instancia de sesion se le da true para crear la sesion
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("listas", producto.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas-productos/listarProductos.jsp");
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
            String pag = "/vistas-productos/crearProductos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
            dispatcher.forward(request, response);
        }else if(parametro.equals("listar")){
            this.listaProductos(request, response);
        
        }else if(parametro.equals("modificar")){
            int id_producto = Integer.parseInt(request.getParameter("id_p"));
             String nom_producto = request.getParameter("nombre_p");
             Float stock_producto = Float.parseFloat(request.getParameter("stock_p"));
             Float precio_producto = Float.parseFloat(request.getParameter("precio_p"));
             String unidad_producto = request.getParameter("unidad_p");
             int estado_producto = Integer.parseInt(request.getParameter("estado_p"));
             int categoria_producto = Integer.parseInt(request.getParameter("cat_p"));
             
             
             String pag = "/vistas-productos/crearProducto.jsp?id_p="+id_producto+"&&nombre_o="+nom_producto+"&&stock_o="+stock_producto+"&&precio_o"+precio_producto+"&&unidad_o"+unidad_producto+"&&estado_o"+estado_producto+"&&categoria_o"+categoria_producto+"&&signal=1";
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
             dispatcher.forward(request, response);
        
        }
        this.listaProductos(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Producto producto = new Producto();
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        String nom_producto = request.getParameter("txtNomProducto");
        float stock_producto = Float.parseFloat(request.getParameter("txtStockProducto"));
        float precio_producto = Float.parseFloat(request.getParameter("txtPrecioProducto"));
        String unidad_producto = request.getParameter("txtUnidadProducto");
        int estado_producto = Integer.parseInt(request.getParameter("txtEstadoProducto"));
        int categoria_producto = Integer.parseInt(request.getParameter("txtCategoriaProducto"));
    
        producto.setId_producto(id_producto);
        producto.setNom_producto(nom_producto);
        producto.setStock(stock_producto);
        producto.setPrecio(precio_producto);
        producto.setUnidad_de_medida(unidad_producto);
        producto.setEstado_producto(estado_producto);
        producto.setCategoria_id(categoria_producto);
        
        
        ProductoDAO guardarPro = new ProdcutoDAOImplementarn();
        guardarPro.guardaPro(producto);
        
        this.listaProductos(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String cosntaining servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
