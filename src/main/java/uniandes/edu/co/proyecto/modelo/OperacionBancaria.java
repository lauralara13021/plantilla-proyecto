package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "operacionesBancarias")

public abstract class OperacionBancaria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private LocalTime hora;
    private LocalDate fecha;
    @OneToOne
    @JoinColumn(name="idOrigen", referencedColumnName = "id")
    private Producto idOrigen;
    @OneToOne
    @JoinColumn(name="idDestino", referencedColumnName = "id")
    private Producto idDestino;
    @OneToOne
    @JoinColumn(name="puntoAtencion", referencedColumnName = "id")
    private PuntoDeAtencion puntoAtencion;
    private int valor;
    private String tipo;
    public OperacionBancaria(Integer id, LocalTime hora, LocalDate fecha, Producto idOrigen, Producto idDestino,
            PuntoDeAtencion puntoAtencion, int valor, String tipo) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.puntoAtencion = puntoAtencion;
        this.valor = valor;
        this.tipo = tipo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Producto getIdOrigen() {
        return idOrigen;
    }
    public void setIdOrigen(Producto idOrigen) {
        this.idOrigen = idOrigen;
    }
    public Producto getIdDestino() {
        return idDestino;
    }
    public void setIdDestino(Producto idDestino) {
        this.idDestino = idDestino;
    }
    public PuntoDeAtencion getPuntoAtencion() {
        return puntoAtencion;
    }
    public void setPuntoAtencion(PuntoDeAtencion puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}

