package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.models.Factura;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FacturaService {
    public List<Factura> listarFacturas();
    public Factura encontrarFacturaPorId(Factura factura);
    public void guardarFactura(Factura factura);
    public void modificarFactura(Factura factura);
    public void eliminarFactura(Factura factura);
}
