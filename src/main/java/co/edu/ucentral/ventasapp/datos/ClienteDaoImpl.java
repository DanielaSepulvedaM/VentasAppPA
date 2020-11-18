package co.edu.ucentral.ventasapp.datos;

import co.edu.ucentral.ventasapp.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class ClienteDaoImpl implements ClienteDao{
    
    @PersistenceContext(unitName="ventasPU")
    EntityManager manager;

    @Override
    public List<Cliente> findAllClientes() {
        return manager.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        return manager.find(Cliente.class, cliente.getId());
    }

    @Override
    public void insertCliente(Cliente cliente) {
        manager.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        manager.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        manager.remove(manager.merge(cliente));
    }

    @Override
    public Cliente findClienteByIdentidad(Cliente cliente) {
        TypedQuery<Cliente> clienteIdenti = manager.createNamedQuery("Cliente.findByIdentidad",Cliente.class);
        clienteIdenti.setParameter("identidad",cliente.getIdentidad());
        return (Cliente) clienteIdenti.getSingleResult();
    }
}
