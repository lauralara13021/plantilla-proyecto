package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public abstract class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ProductosPK pk;
    //private Integer id;
    private String estado;
    private String tipo;
    private Integer dinero;
    
    
    


    public Cuenta(ProductosPK pk, String estado, String tipo, Integer dinero) {
        this.pk = pk;
        //this.id = id;
        this.estado = estado;
        this.tipo = tipo;
        this.dinero = dinero;
    }





    public Cuenta()
    {;}





    public ProductosPK getPk() {
        return pk;
    }





    public void setPk(ProductosPK pk) {
        this.pk = pk;
    }


  



    public String getEstado() {
        return estado;
    }





    public void setEstado(String estado) {
        this.estado = estado;
    }





    public String getTipo() {
        return tipo;
    }





    public void setTipo(String tipo) {
        this.tipo = tipo;
    }





    public Integer getDinero() {
        return dinero;
    }


    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }


   
}
