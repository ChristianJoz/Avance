<%-- 
    Document   : 17
    Created on : 06-19-2020, 04:56:17 PM
    Author     : Palacios
--%>

<%@page import="Model.Producto"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Producto"%><!--Importa el modelo -->
<!--El id debe ser el mismo que le coloco de nombre a la sesion en el controlador  -->
<jsp:useBean id = "listas" scope="session" class = "java.util.List"  />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario control</title>
        <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
        <div  >
            <a href="<%= request.getContextPath() %>/Producto?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"  >Agregar Producto +</a>
            <a onclick="javascript:window.imprimirDIV('ID_DIV');" href="#"  class="btn btn-success btn-sm " role="button" ><span class="glyphicon glyphicon-print"> PDF</span> </a>
             <a href="pdf" class="btn btn-danger btn-sm glyphicon glyphicon-print" role="button"  > Imprimir Reg+</a>
            <h3>Listado de Productos Registrados</h3>
             <script>
                function imprimirDIV(ID_DIV) {
                var ficha = document.getElementById(ID_DIV);
                 var ventanaImpresion = window.open(' ', 'popUp');
                ventanaImpresion.document.write(ficha.innerHTML);
                ventanaImpresion.document.close();
                ventanaImpresion.print();
                ventanaImpresion.close();
                 }
      </script>
        <div id="ID_DIV" >
            <table class="table table-striped"  >
                      
                
                    <tr>
                        <th> CODIGO </th>
                        <th> NOMBRE </th>
                        <th> STOCK </th>
                        <th> PRECIO </th>
                        <th> U MEDIDA </th>
                        <th> ESTADO </th>
                        <th> CAT. </th>
                        <th></th>
                    </tr>
                    <% 
                        for (int i =0 ; i < listas.size(); i++){
                        Producto producto = new Producto();
                        producto = (Producto)listas.get(i);
                        
                        
                        %>
                    <tr>
                        
                       <td> <%= producto.getId_producto()%> </td>
                       <td> <%= producto.getNom_producto()%> </td>
                       <td> <%= producto.getStock()%> </td>
                       <td> $ <%= producto.getPrecio()%> </td>
                       <td> <%= producto.getUnidad_de_medida()%> </td>
                       <td> <%= producto.getEstado_producto()%> </td>
                        <td> <%= producto.getCategoria_id()%> </td>
                       
                       <td>
                           <a href="#" class="btn btn-info btn-sm glyphicon glyphicon-pencil" role="button" ></a> 
                           <%--<%= request.getContextPath() %>/Categorias?opcion=modificar&&id=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %> --%>
                           <a href="#" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button" ></a> 
                           <%--<%= request.getContextPath() %>/Categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>--%>
                       </td>
                    </tr>
                    <%
                       }
                    %>

                </table>
        </div>

        </div>
      <%@include file="../WEB-INF/vistas-parciales/pie.jspf" %>               
    </body>
</html>
