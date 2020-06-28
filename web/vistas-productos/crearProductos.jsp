<%-- 
    Document   : crearCategoria
    Created on : 06-23-2020, 07:24:19 AM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />

<%
String id_p= "";
String nombre_p = "";
String stock_p = "";
String precio_p = "";
String unidad_p = "";
String estado_p = "";
String cat_p = "";

if (request.getParameter("signal")!=null) {
        id_p = request.getParameter("id_o");
        nombre_p = request.getParameter("nombre_o");
        stock_p = request.getParameter("stock_o");
        precio_p = request.getParameter("precio_o");
        unidad_p = request.getParameter("unidad_o");
        estado_p = request.getParameter("estado_o");
        cat_p = request.getParameter("categoria_o");
        
    }else{
    id_p = String.valueOf(producto.getId_producto());//Id definido a cero desde el constructor
    nombre_p = producto.getNom_producto();
    stock_p = String.valueOf(producto.getStock());
    precio_p = String.valueOf(producto.getPrecio());
    unidad_p = String.valueOf(producto.getUnidad_de_medida());
    estado_p = String.valueOf(producto.getEstado_producto());
    cat_p = String.valueOf(producto.getCategoria_id());
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
        <h1>Agregar Producto Nuevo!</h1>
        <form action="<%= request.getContextPath() %>/Producto" method="post">
           
            <input type="hidden" name="id_producto" value="<%= id_p%>"  >
            <div class="form-group">
                <label for="txtNomProducto" class="col-sm-2 control label" >Nombre:</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtNomProducto" value="<%= nombre_p %>" required />
                </div>        
            </div>
            
            <div class="form-group">
                <label for="txtStockProducto" class="col-sm-2 control label" >Stock</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtStockProducto" value="<%= stock_p %>" required />
                </div>        
            </div>
                
             <div class="form-group">
                <label for="txtPrecioProducto" class="col-sm-2 control label" >Precio</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtPrecioProducto" value="<%= precio_p %>" required />
                </div>        
            </div>
                
            <div class="form-group">
                <label for="txtUnidadProducto" class="col-sm-2 control label" >Unidad</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtUnidadProducto" value="<%= unidad_p %>" required />
                </div>        
            </div>
            
            <div class="form-group">
                    <label for="txtEstadoProducto" class="col-sm-2 control label" >Estado</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= estado_p %>" required />
                </div>        
            </div>
                
            <div class="form-group">
                <label for="txtCategoriaProducto" class="col-sm-2 control label" >Categoria</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtCategoriaProducto" value="<%= cat_p %>" required />
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
