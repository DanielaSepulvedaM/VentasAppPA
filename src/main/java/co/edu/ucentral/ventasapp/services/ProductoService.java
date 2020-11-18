/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.ventasapp.services;

import co.edu.ucentral.ventasapp.models.Producto;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProductoService {
    public List<Producto> listarProductos();
    public Producto encontrarProductoPorId(Producto producto);
    public void guardarProducto(Producto producto);
    public void modificarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
}
