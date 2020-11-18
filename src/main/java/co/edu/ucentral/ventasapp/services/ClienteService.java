package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.models.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteService {
    public List<Cliente> listarClientes();
    public Cliente encontrarClientePorId(Cliente cliente);
    public Cliente encontrarClientePorIdentidad(Cliente cliente);
    public void guardarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
    
}
