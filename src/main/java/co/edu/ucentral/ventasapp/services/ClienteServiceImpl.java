package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.datos.ClienteDao;
import co.edu.ucentral.ventasapp.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteServiceImpl implements ClienteService{

    @Inject
    private ClienteDao clienteDao;
    
    @Override
    public List<Cliente> listarClientes() {
        return clienteDao.findAllClientes();
    }

    @Override
    public Cliente encontrarClientePorId(Cliente cliente) {
        return clienteDao.findClienteById(cliente);
    }

    @Override
    public Cliente encontrarClientePorIdentidad(Cliente cliente) {
        return clienteDao.findClienteByIdentidad(cliente);
    }
    
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDao.insertCliente(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        clienteDao.updateCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteDao.deleteCliente(cliente);
    }

    
    
}
