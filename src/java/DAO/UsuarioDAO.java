package DAO;

import Model.Usuario;
import java.util.ArrayList;


public interface UsuarioDAO {
     public ArrayList<Usuario> startSesion(String user, String clave);
}
