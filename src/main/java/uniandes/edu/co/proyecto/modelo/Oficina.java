package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "oficinas")
public abstract class Oficina {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    @OneToOne
    @JoinColumn(name="direccion", referencedColumnName = "id")
    private Direccion direccion;
    private Integer puntosAtencion;
    

    public Oficina(Integer id, String nombre, Direccion direccion, Integer puntosAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.puntosAtencion = puntosAtencion;
    }

    public Oficina()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getPuntosAtencion() {
        return puntosAtencion;
    }

    public void setPuntosAtencion(Integer puntosAtencion) {
        this.puntosAtencion = puntosAtencion;
    }

    

    
}
