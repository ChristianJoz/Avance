/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.ProductoDAO;
import DAO.ProdcutoDAOImplementarn;
import Model.Producto;
import java.util.List;



public class Prueba2 {
    public static void main(String[] args) {
        Prueba2 evaluar = new Prueba2();
        evaluar.listarCategorias();
       // evaluar.editarCategoria();
       // evaluar.guardaCategoria();
        //evaluar.eliminarCategoria();
    }

    private void listarCategorias() {
       ProductoDAO categoria = new ProdcutoDAOImplementarn(); //To change body of generated methods, choose Tools | Templates.
       List<Producto> listar = categoria.Listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for ( Producto categoriaListar : listar) {
            System.out.println("ID: "+categoriaListar.getId_producto()
            + " NOMBRE: "+ categoriaListar.getNom_producto()
            + " STOCK: "+categoriaListar.getStock()
            +" PRECIO: "+categoriaListar.getPrecio()
            +" UNIDAD: "+categoriaListar.getUnidad_de_medida());
        }
    }

   
    
}
