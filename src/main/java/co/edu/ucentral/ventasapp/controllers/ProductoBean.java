package co.edu.ucentral.ventasapp.controllers;

import co.edu.ucentral.ventasapp.models.Producto;
import co.edu.ucentral.ventasapp.services.ProductoService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("productoBean") //notacion para saber q es un bean y poner el nombre para saber que se esta hablando del objeto de esta clase
@RequestScoped //para indicar el alcance (applications, session, request)

public class ProductoBean {
   
    @Inject
   private ProductoService productoService;
   
   private List<Producto>productos;
   private Producto producto;

    public ProductoBean() {
    }
   
   @PostConstruct
    public void inicializar(){
        productos = productoService.listarProductos(); //trae un objeto cliente
        producto = new Producto(); //intanciar cliente normal por q no se realizo inyeccion
    }
    
    public String nuevoProducto(){
        this.producto=new Producto();
        return "formProducto";
    }

    
    public String guardarProducto(){
        this.productoService.guardarProducto(producto);
        this.productos.add(producto);
        this.producto=null;
        return "listadoProductos";
    }
    
    public String editar(int idProducto){
        producto = new Producto();
        producto.setId(idProducto);
        producto=this.productoService.encontrarProductoPorId(producto);
        return "formProducto";
    }
    
    public String modificar(){
        this.productoService.modificarProducto(producto);
        productos=productoService.listarProductos();
        return "listadoProductos";
    }
    
    public String eliminar(int idProducto){
        producto = new Producto();
        producto.setId(idProducto);
        productoService.eliminarProducto(producto);
        productos = productoService.listarProductos();
        return "listadoProductos";
    }
    
    public String enviar(){
        String url = "";
        if(producto.getId() != null){
            url=this.modificar();       
        }else{
            url = this.guardarProducto();
     
        }
        return url;
    }
    
    
    //*****************************

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    } 
}
