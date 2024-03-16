package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public abstract class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="numDocumento", referencedColumnName = "id")
    private Persona numDocumento;
    private String tipoDocumento;
    private String nombre;
    private String nacionalidad;
    @OneToOne
    @JoinColumn(name="direccion", referencedColumnName = "id")
    private Direccion direccion;
    private String direccionElectronica;
    private String telefono;
    private String palabraClave;
    @OneToOne
    @JoinColumn(name="oficina", referencedColumnName = "id")
    private Oficina oficina;
    private Integer sueldo;
    private String tipoEmpleado;
    public Empleado(Integer id, Persona numDocumento, String tipoDocumento, String nombre, String nacionalidad,
            Direccion direccion, String direccionElectronica, String telefono, String palabraClave, Oficina oficina,
            Integer sueldo, String tipoEmpleado) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
        this.palabraClave = palabraClave;
        this.oficina = oficina;
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }
    public Empleado()
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Persona getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(Persona numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public String getDireccionElectronica() {
        return direccionElectronica;
    }
    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPalabraClave() {
        return palabraClave;
    }
    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public Integer getSueldo() {
        return sueldo;
    }
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
}
