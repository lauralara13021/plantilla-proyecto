package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")

public abstract class Cliente {
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
    private String tipoCliente;
    public Cliente(Integer id, Persona numDocumento, String tipoDocumento, String nombre, String nacionalidad,
            Direccion direccion, String direccionElectronica, String telefono, String palabraClave,
            String tipoCliente) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
        this.palabraClave = palabraClave;
        this.tipoCliente = tipoCliente;
    }
    public Cliente()
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
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
}
