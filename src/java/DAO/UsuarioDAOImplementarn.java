
package DAO;

import Model.Usuario;
import java.util.ArrayList;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import java.sql.ResultSet;


public class UsuarioDAOImplementarn implements UsuarioDAO {
    
    ConexionDB conn; 

    @Override
    public ArrayList<Usuario> startSesion(String user, String clave) {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
         StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario WHERE correo = '").append(user);
        miSQL.append("' and clave = ('").append(clave);
        miSQL.append("');");  
        
         ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
       
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
           
                usuario.setId(resultadoSQL.getInt("id_usuario"));
                usuario.setNombre(resultadoSQL.getString("nombre_u"));
                usuario.setApellido(resultadoSQL.getString("apellido_u"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
                usuario.setFecharegistro(resultadoSQL.getString("f_registro"));
                lista.add(usuario); 
                
                
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
    
    return lista;
    }
    
    
    
}
