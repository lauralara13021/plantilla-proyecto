package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numeroDocumento;
    public Persona(Integer id, String numeroDocumento) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
    }
    public Persona()
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    
}
