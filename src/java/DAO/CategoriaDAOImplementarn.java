/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Factory.FactoryConexionDB;
import Factory.ConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAOImplementarn implements CategoriaDAO {

    ConexionDB conn;
    
    public CategoriaDAOImplementarn() {
        
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        
    }

    @Override
    public List<Categoria> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_categoria;");
        List<Categoria> lista = new ArrayList<Categoria>();
        try{
           
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            Categoria categoria = new Categoria();
            
            categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
            categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
            categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
            lista.add(categoria);
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Categoria categoria = new Categoria();
        StringBuilder miSQL = new StringBuilder();
        //Agregar la consulta SQL
        miSQL.append("SELECT * FROM tb_categoria WHERE id_categoria ='").append(id_cat_edit);
        miSQL.append("';");
        try{// Realiza la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
            categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
            categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
            }       
        }catch(Exception ex){
              
        }finally{
        this.conn.cerrarConexion();
        }
        return categoria;
        
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false; 
        try{
            if (categoria.getId_categoria()== 0) {
            StringBuilder miSQL = new StringBuilder();    
            
            miSQL.append("INSERT INTO tb_categoria(nom_categoria, estado_categoria) VALUES ('");
            miSQL.append(categoria.getNom_categoria()+ "',").append(categoria.getEstado_categoria());
            miSQL.append(");");
            
            this.conn.ejecutarSQL(miSQL.toString());
            }else if (categoria.getId_categoria() > 0){
            }
        }catch(Exception e){
        }finally{
        this.conn.cerrarConexion();
        }
        return guarda;
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borra = false; 
        try {
            StringBuilder miSQL = new StringBuilder();
             miSQL.append("DELETE FROM tb_categoria WHERE id_categoria =").append(id_cat_borrar);
           
            this.conn.ejecutarSQL(miSQL.toString());
             borra = true;
        }catch(Exception e){
        
        }finally{
        this.conn.cerrarConexion();
        }
      return borra;
        
    
    }
   
    public static void main(String[] args) {
        CategoriaDAO categoria = new CategoriaDAOImplementarn();
           List<Categoria> listar = categoria.Listar();
        for ( Categoria categoriaListar : listar) {
            System.out.println("ID: "+categoriaListar.getId_categoria()
            + " NOMBRE: "+ categoriaListar.getNom_categoria()
            + " ESTADO: "+categoriaListar.getEstado_categoria());
        }
    }
}
