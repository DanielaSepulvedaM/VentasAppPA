package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.datos.ProductoDao;
import co.edu.ucentral.ventasapp.models.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoDao productoDao;
    @Override
    public List<Producto> listarProductos() {
        return productoDao.findAllProductos();
    }

    @Override
    public Producto encontrarProductoPorId(Producto producto) {
        return productoDao.findProductoById(producto);
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoDao.insertProducto(producto);
    }

    @Override
    public void modificarProducto(Producto producto) {
        productoDao.updateProducto(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoDao.deleteProducto(producto);
    }
    
}
