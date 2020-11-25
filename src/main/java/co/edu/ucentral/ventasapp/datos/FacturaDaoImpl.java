package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacturaDaoImpl implements FacturaDao{

    @PersistenceContext(unitName="ventasPU")
    private EntityManager manager;
    
    
    @Override
    public List<Factura> findAllFacturas() {
        return manager.createNamedQuery("Factura.findAll").getResultList();
    }

    @Override
    public Factura findFacturaById(Factura factura) {
        return manager.find(Factura.class, factura.getId());
    }

    @Override
    public void insertFactura(Factura factura) {
        manager.persist(factura);
    }

    @Override
    public void updateFactura(Factura factura) {
        manager.merge(factura);
    }

    @Override
    public void deleteFactura(Factura factura) {
        manager.remove(manager.merge(factura));
    }
    
}
