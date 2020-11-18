package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductoDaoImpl implements ProductoDao{

     @PersistenceContext(unitName="ventasPU")
    EntityManager manager;

    @Override
    public List<Producto> findAllProductos() {
        return manager.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return manager.find(Producto.class, producto.getId());
    }

    @Override
    public void insertProducto(Producto producto) {
        manager.persist(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        manager.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        manager.remove(this.manager.merge(producto));
    }
    
}
