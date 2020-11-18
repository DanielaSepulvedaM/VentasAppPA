package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Cliente;
import java.util.List;


public interface ClienteDao {
    public List<Cliente> findAllClientes();
    public Cliente findClienteById(Cliente cliente);
    public Cliente findClienteByIdentidad(Cliente cliente);
    public void insertCliente(Cliente cliente);
    public void updateCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente);
}
