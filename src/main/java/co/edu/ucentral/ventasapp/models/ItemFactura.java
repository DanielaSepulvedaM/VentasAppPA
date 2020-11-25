package co.edu.ucentral.ventasapp.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_facturas")
@NamedQueries({
    @NamedQuery(name = "ItemFactura.findAll", query = "SELECT i FROM ItemFactura i"),
    @NamedQuery(name = "ItemFactura.findById", query = "SELECT i FROM ItemFactura i WHERE i.id = :id"),
    @NamedQuery(name = "ItemFactura.findByCantidad", query = "SELECT i FROM ItemFactura i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemFactura.findByPrecio", query = "SELECT i FROM ItemFactura i WHERE i.precio = :precio")})
public class ItemFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)//agregar prop de cascade si es un elemento que va a guardar varios elementos
    private Factura factura;

    public ItemFactura() {
    }

    public ItemFactura(Integer id) {
        this.id = id;
    }

    public ItemFactura(Integer id, int cantidad, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
    public double getTotal(){
        return this.cantidad*this.precio;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemFactura)) {
            return false;
        }
        ItemFactura other = (ItemFactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.ventasapp.models.ItemFactura[ id=" + id + " ]";
    }
    
}
