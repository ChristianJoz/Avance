package DAO;

import Model.Producto;
import java.util.List;


public interface ProductoDAO {
    public List<Producto> Listar();
    public List<Producto> Listar2();
    public Producto editarPro(int id_pro_edit);
    public boolean guardaPro(Producto producto);
    public boolean borrarPro(int id_pro_edit);
}
