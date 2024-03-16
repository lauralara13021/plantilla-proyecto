
package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")


public abstract class Direccion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String direccion;
    @ManyToOne
    @JoinColumn(name="codigoPostal", referencedColumnName = "id")
    private CodigoPostal codigoPostal;

    

    public Direccion(Integer id, String direccion, CodigoPostal codigoPostal) {
        this.id = id;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }



    public Direccion()
    {;}



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public CodigoPostal getCodigoPostal() {
        return codigoPostal;
    }



    public void setCodigoPostal(CodigoPostal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    

    
    
}
 