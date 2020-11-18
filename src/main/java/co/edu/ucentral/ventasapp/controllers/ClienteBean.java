package co.edu.ucentral.ventasapp.controllers;

import co.edu.ucentral.ventasapp.models.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.ventasapp.services.ClienteService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//clase normal de java pero tiene una notacion para realizar la inyeccion de atributos

@Named("clienteBean") //notacion para saber q es un bean y poner el nombre para saber que se esta hablando del objeto de esta clase
@RequestScoped //para indicar el alcance (applications, session, request)
public class ClienteBean {
    @Inject //se inyecto clienteService
    private ClienteService clienteService;
    
    private List<Cliente>clientes;
    private Cliente cliente; //no se puedeen inyectar por que no tiene la notacion se debe intanciar normal 
    

    //****CONTRUCTOR****
    public ClienteBean() {
    }
    
    //****ir a la BD y consultar la informacion que se ejecute cada vez que valla al objeto poner la notacion****
    @PostConstruct //****ANOTACION PARA Q SIEMPRE DE EJECUTE ESTE METODO ****
    public void inicializar(){
        clientes = clienteService.listarClientes(); //trae un objeto cliente
        cliente = new Cliente(); //intanciar cliente normal por q no se realizo inyeccion
        
    
    }
    
    //METODO NUEVO CLIENTE
    public String nuevoCliente(){
        //inicializar el cluente en vacio
        this.cliente=new Cliente();
        return "nuevoCliente";//retornanr a una nueva pagina
    }
    
    public String guardarCliente(){
        Cliente cliente1 = clienteService.encontrarClientePorIdentidad(cliente);
        if(cliente1 != null){
            String msg = "El cliente con identidad"+ cliente1.getIdentidad()+"  ya existe.";
            FacesMessage  facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            //identificar que componente nos envio ese mensaje
            FacesContext facesContext = FacesContext.getCurrentInstance();
            //necesitamos 2 cosas el faces MEssahge subirlo al faces context y el id
            String componentId = null;
            //subir al facesContext el  facesContext estamos hablando de la pgna q me envio ese msg
            facesContext.addMessage(componentId,facesMessage);
            //retorna a nuevo cliente q se quede en la misma phn de donde fue invocado 
            return "nuevoCliente";
        }
        this.clienteService.guardarCliente(cliente);
        this.clientes.add(cliente);
        this.cliente=null;
        return "listadoClientes";//retornar a la pagina quq uno considere
        
    }
    
    public String editar(int idCliente){
        //inicializar el cluente
        cliente = new Cliente();
        cliente.setId(idCliente);
        cliente=this.clienteService.encontrarClientePorId(cliente);
        return "edicionCliente";
    }
    
    public String modificarCliente(){
        this.clienteService.modificarCliente(cliente);
        clientes=clienteService.listarClientes(); //otra forma
        return "listadoClientes";//retornar a la pagina quq uno considere
    
    
    }
    public String eliminar(int idCliente){
       cliente = new Cliente();
       cliente.setId(idCliente);
       this.clienteService.eliminarCliente(cliente);
       clientes = this.clienteService.listarClientes();
        return "listadoClientes";//retornar a la pagina quq uno considere
    
    
    }
    
    //METODOS GET Y SET DE LOS 2 ATRIBUTOS QUE NO SE INYECTARON
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
