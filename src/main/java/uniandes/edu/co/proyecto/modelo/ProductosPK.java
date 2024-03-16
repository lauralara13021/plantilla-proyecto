package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ProductosPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "producto", referencedColumnName = "id")
    private Producto producto;

    public ProductosPK(Producto producto) {
        super();
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
