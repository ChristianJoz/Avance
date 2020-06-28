<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria" />

<%
String id= "";
String nombre_cat = "";
String estado_cat = "";

if (request.getParameter("signal")!=null) {
        id = request.getParameter("id_c");
        nombre_cat = request.getParameter("nombre_c");
        estado_cat = request.getParameter("estado_c");
    }else{
    id = String.valueOf(categoria.getId_categoria());//Id definido a cero desde el constructor
    nombre_cat = categoria.getNom_categoria();
    estado_cat = String.valueOf(categoria.getEstado_categoria());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body>
         <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
        <h1>Agregar Categoria nueva!</h1>
        <form action="<%= request.getContextPath() %>/Categorias" method="post">
           
            <input type="hidden" name="id_categoria" value="<%= id%>"  >
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control label" >Nombre:</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtNomCategoria" value="<%= nombre_cat %>" required />
                </div>        
            </div>
            
            <div class="form-group">
                <label for="txtEstadoCategoria" class="col-sm-2 control label" >Estado:</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= estado_cat %>" required />
                </div>        
            </div>
                
            <div>
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                       if (request.getParameter("signal")!=null) {
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnEditar" value="Editar"/>
                    <%
                    }else{
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnGuardar" value="Guardar"/>    
                    <%
                    }
                    %>
                
                </div>
                
            </div>
        
                
           
            
        </form>
          <%@include file="../WEB-INF/vistas-parciales/pie.jspf" %>               
    </body>
</html>
