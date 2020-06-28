
<%@page import="Model.Categoria"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Categoria"%><!--Importa el modelo -->

<jsp:useBean id = "lista" scope="session" class = "java.util.List"  />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario control</title>
        <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
        <div  >
            <a href="<%= request.getContextPath() %>/Categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"  >Agregar Categoria +</a>
            <a onclick="javascript:window.imprimirDIV('ID_DIV');" href="#"  class="btn btn-success btn-sm " role="button" ><span class="glyphicon glyphicon-print"> PDF</span> </a>
             <a href="pdf" class="btn btn-danger btn-sm glyphicon glyphicon-print" role="button"  > Imprimir Reg+</a>
            <h3>Listado de categorias Registradas</h3>
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
                        <th> STATUS </th>
                        <th></th>
                    </tr>
                    <% 
                        for (int i =0 ; i < lista.size(); i++){
                        Categoria categoria = new Categoria();
                        categoria = (Categoria)lista.get(i);
                        
                        
                        %>
                    <tr>
                        
                       <td> <%= categoria.getId_categoria() %> </td>
                       <td> <%= categoria.getNom_categoria() %> </td>
                       <td> <%= categoria.getEstado_categoria() %> </td>
                       <td>
                           <a href="<%= request.getContextPath() %>/Categorias?opcion=modificar&&id=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-pencil" role="button" ></a> 
                           <a href="<%= request.getContextPath() %>/Categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button" ></a> 
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
