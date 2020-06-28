package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementarn;
import Model.Usuario;
import DAO.UsuarioImplementarn2;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/log.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		
		UsuarioImplementarn2 userDao = new UsuarioImplementarn2();
		
		try {
			Usuario user = userDao.VerLogin(email, password);
			String destPage = "log.jsp";
			
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				destPage = "index.jsp";
			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
        
       /* Usuario os = new Usuario();
       // Usuario User = New Usuario();
        //variables que toman los datos ingresados desde la vista del login
        String dato_user_form = request.getParameter("inputEmail");
        String dato_pass_form = request.getParameter("inputPassword");
        
        //String corr = 
        //Se instancia el usuario
        UsuarioDAO usuario = new UsuarioDAOImplementarn();
        //Arraylist para cargar todos los datos del usuario para cargar los metodos de consulta de la DB
        ArrayList<Usuario> users = new ArrayList();
        //Crear variable que permite verificar si se ha logueado
        HttpSession var_Session= request.getSession(true);
        //Se pasan los datos del la base de datos (tb_usuario) a imprimir al arraylist para ser manipulados
        users = usuario.startSesion(dato_user_form, dato_pass_form);
        //Comprobar si hay datos hay datos en el array, si los hay es por que los logueo con exito
        if (os.getCorreo()== dato_user_form && os.getClave() == dato_pass_form) {
            String name_full = users.get(0).getNombre() + " " + users.get(0).getApellido();
            //Con el valor que recibo en la variable tipo_user se puede realizar un acceso a diferentes vistas
            //Por ejemplo: Si tipo = 0, que vaya a la vista menu1.jsp. Si tipo = 1, que vaya a la vista menu2.jsp...
            int tipo_user = users.get(0).getTipo();
            String name_user = users.get(0).getUsuario();
            String email_user = users.get(0).getCorreo();
            
            var_Session.setAttribute("sessionNombres", name_full);
            //request.getSession().setAttribute("sessionNombres", name_full);      //asigancion de valores de la session
            var_Session.setAttribute("sessionTipo", String.valueOf(tipo_user));
            var_Session.setAttribute("sessionUsuario", name_user);
            var_Session.setAttribute("sessionEmail", email_user);
            
             var_Session.setAttribute("lista", users);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }else{
            try (PrintWriter out = response.getWriter()) {
            String url = "Login";   
                        out.println("<script>valor=confirm(\"Error. Usuario o Clave Incorrecto. " +"\\nNombre de Usuario: "  + dato_user_form + " \\n\\nClic en aceptar para volver a intentarlo. \");valor;"
                        + "if (valor==true){"
                        + "location.href='"+ url + "';"
                        + "}else{"
                        + "location.href='"+ url + "';"
                        + "}"
                        + "</script>");
                }
        
            }*/
    
        }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
