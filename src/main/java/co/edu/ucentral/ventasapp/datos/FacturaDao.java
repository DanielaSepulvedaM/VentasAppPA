package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Factura;
import java.util.List;

public interface FacturaDao {
    public List<Factura> findAllFacturas();
    public Factura findFacturaById(Factura factura);
    public void insertFactura(Factura factura);
    public void updateFactura(Factura factura);
    public void deleteFactura(Factura factura);
}
