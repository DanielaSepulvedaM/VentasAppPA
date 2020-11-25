package co.edu.ucentral.ventasapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "facturas")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    @NamedQuery(name = "Factura.findByObservacion", query = "SELECT f FROM Factura f WHERE f.observacion = :observacion"),
    @NamedQuery(name = "Factura.findByCreateAt", query = "SELECT f FROM Factura f WHERE f.createAt = :createAt")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.LAZY)
    private List<ItemFactura> itemFacturaList;

    public Factura() {
        this.itemFacturaList = new ArrayList();
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItemFacturaList() {
        return itemFacturaList;
    }

    public void setItemFacturaList(List<ItemFactura> itemFacturaList) {
        this.itemFacturaList = itemFacturaList;
    }
    
     public double getGranTotal(){
        double valor = 0;
        for(ItemFactura item: this.itemFacturaList){
            valor = valor + item.getTotal();
        }
        return valor;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "co.edu.ucentral.ventasapp.models.Factura[ id=" + id + " ]";
    }
    
}
