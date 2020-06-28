/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Producto;
import java.util.List;
import Factory.FactoryConexionDB;
import Factory.ConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdcutoDAOImplementarn implements ProductoDAO {
   ConexionDB conn;
    @Override
    public List<Producto> Listar() {
           this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_producto;");
        List<Producto> lista = new ArrayList<Producto>();
        try{
          
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            Producto producto = new Producto();
            
            producto.setId_producto(resultadoSQL.getInt("id_producto"));
            producto.setNom_producto(resultadoSQL.getString("nom_producto"));
            producto.setStock(resultadoSQL.getInt("stock"));
            producto.setPrecio(resultadoSQL.getFloat("precio"));
            producto.setUnidad_de_medida(resultadoSQL.getString("unidad_de_medida"));
            producto.setEstado_producto(resultadoSQL.getInt("estado_producto"));
            producto.setCategoria_id(resultadoSQL.getInt("categoria"));
            lista.add(producto);
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Producto editarPro(int id_cat_edit) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   


    @Override
    public boolean borrarPro(int id_pro_edit) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean guardaPro(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false;
        try{
            if (producto.getId_producto()== 0) {
            StringBuilder miSQL = new StringBuilder();    
          
            miSQL.append("INSERT INTO tb_producto(nom_producto, stock, precio, unidad_de_medida, estado_producto, categoria) VALUES ('");
            miSQL.append(producto.getNom_producto()+ "','").append(producto.getStock()+"','").append(producto.getPrecio()+"','").append(producto.getUnidad_de_medida()+"','").append(producto.getEstado_producto()+"','").append(producto.getCategoria_id());
            miSQL.append(");");
            
            this.conn.ejecutarSQL(miSQL.toString());
            }else if (producto.getId_producto() > 0){
            }
        }catch(Exception e){
            System.out.println("Error en la   consulta");
        }finally{
        this.conn.cerrarConexion();
        }
        return guarda;
    }
    
}
