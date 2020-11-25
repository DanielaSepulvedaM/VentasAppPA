package co.edu.ucentral.ventasapp.controllers;


import co.edu.ucentral.ventasapp.models.Cliente;
import co.edu.ucentral.ventasapp.models.Factura;
import co.edu.ucentral.ventasapp.models.ItemFactura;
import co.edu.ucentral.ventasapp.models.Producto;
import co.edu.ucentral.ventasapp.services.ClienteService;
import co.edu.ucentral.ventasapp.services.FacturaService;
import co.edu.ucentral.ventasapp.services.ProductoService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("facturaBean")//el nombre que se le dio para luego usarlo en otro lado
@SessionScoped
public class FacturaBean implements Serializable{
    
    @Inject
    private FacturaService  facturaService;
    
    @Inject
    private ClienteService clienteService;
    
    @Inject
    private ProductoService productoService;
    
    private Factura factura;
    private List<Factura>facturas;
    private List<Cliente>clientes;
    private List<Producto>productos;
    private Integer idCliente;
    private Integer cantidad; //se usa cuando digitemos la cantidad del producto al seleccionarlo
    private Integer idProducto;
    private ItemFactura itemFactura;
    
    
    
    //CONTRUCTOR
    public FacturaBean() {    
        
    }
    
    //METODO QUE INICIALICE LOS ATRIBUTOS
    @PostConstruct
    public void inicializar(){
        facturas = facturaService.listarFacturas();
        clientes = clienteService.listarClientes();
        productos = productoService.listarProductos();
        factura = new Factura();
    }

    public String crearFactura(){
        iniciarAtributos();
        return "nuevaFactura";
    }
    
    public String guardar(){
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        cliente=clienteService.encontrarClientePorId(cliente);
        factura.setCliente(cliente);
        this.facturaService.guardarFactura(factura);
        this.facturas.add(factura);
        this.factura=null;
        return "listadoFacturas";
    
    }
    
    public String editar(int idFactura){
        return "editFactura";
    }
    
    public String eliminar(int idFactura){
       return "listadoFacturas";
    
    }
    
    public String addItem(){
        if(this.idProducto != null){
            this.itemFactura = new ItemFactura();
            Producto prod = new Producto();
            prod.setId(idProducto);
            Producto producto = productoService.encontrarProductoPorId(prod);
            itemFactura.setProducto(producto);
            itemFactura.setPrecio(producto.getPrecio());
            itemFactura.setCantidad(cantidad);
            itemFactura.setFactura(factura);
            factura.getItemFacturaList().add(itemFactura);
        }
        return "nuevaFactura";
    }
    
     private void iniciarAtributos() {
        //inicializar todos los atributos 
        this.factura=new Factura();
        this.factura.setCreateAt(new Date());
        this.idCliente=0;
        //capturar info de toda la factura
        this.cantidad=0;
        this.idProducto=0;
        this.itemFactura=new ItemFactura();
    }   
     
    
    
    
    //metodos GET Y SET
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ItemFactura getItemFactura() {
        return itemFactura;
    }

    public void setItemFactura(ItemFactura itemFactura) {
        this.itemFactura = itemFactura;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    

   
}
