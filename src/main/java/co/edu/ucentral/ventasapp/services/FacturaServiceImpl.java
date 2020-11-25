package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.datos.FacturaDao;
import co.edu.ucentral.ventasapp.models.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FacturaServiceImpl implements FacturaService{

    @Inject
    private FacturaDao facturaDao;

    @Override
    public List<Factura> listarFacturas() {
        return facturaDao.findAllFacturas();
    }

    @Override
    public Factura encontrarFacturaPorId(Factura factura) {
        return facturaDao.findFacturaById(factura);
    }

    @Override
    public void guardarFactura(Factura factura) {
        facturaDao.insertFactura(factura);
    }

    @Override
    public void modificarFactura(Factura factura) {
        facturaDao.updateFactura(factura);
    }

    @Override
    public void eliminarFactura(Factura factura) {
        facturaDao.deleteFactura(factura);
    }
    
    
    
}
