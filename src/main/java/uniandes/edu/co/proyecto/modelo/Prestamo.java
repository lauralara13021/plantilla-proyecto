package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public abstract class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ProductosPK pk;
    //private int id;
    private String estado;
    private String tipo;
    private Double interes;
    private Integer cuotas;
    private Double valorCuota;
    private Integer monto;
    private String diaCorte;
    private Double saldoPendiente;
    public Prestamo(ProductosPK pk, String estado, String tipo, Double interes, Integer cuotas, Double valorCuota,
            Integer monto, String diaCorte, Double saldoPendiente) {
        this.pk = pk;
        //this.id = id;
        this.estado = estado;
        this.tipo = tipo;
        this.interes = interes;
        this.cuotas = cuotas;
        this.valorCuota = valorCuota;
        this.monto = monto;
        this.diaCorte = diaCorte;
        this.saldoPendiente = saldoPendiente;
    }
    
    public Prestamo()
    {;}

    public ProductosPK getPk() {
        return pk;
    }

    
    public void setPk(ProductosPK pk) {
        this.pk = pk;
    }


    /* 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }
*/
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

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(String diaCorte) {
        this.diaCorte = diaCorte;
    }

    public Double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(Double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }
    
   
}

        
