package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Producto;
import java.util.List;

public interface ProductoDao {
    public List<Producto> findAllProductos();
    public Producto findProductoById(Producto producto);
    public void insertProducto(Producto producto);
    public void updateProducto(Producto producto);
    public void deleteProducto(Producto producto);
}
