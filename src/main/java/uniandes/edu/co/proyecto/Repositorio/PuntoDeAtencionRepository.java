package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.ProductosPK;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion,Integer> {
    @Query(value = "SELECT p FROM PuntoDeAtencion p")
    Collection<PuntoDeAtencion> getPuntoDeAtencion();

    @Query(value = "SELECT * FROM puntosAtencion WHERE id= :id", nativeQuery = true )
    PuntoDeAtencion getPuntoDeAtencion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntosAtencion (id, tipo, localizacion, oficina) VALUES(bancandes_sequence.nextval, :tipo, :localizacion, :oficina", nativeQuery = true )
    void insertarPuntoDeAtencion(@Param("tipo") String tipo, @Param("localizacion") Direccion direccion, @Param("oficina") Oficina oficina);


    @Modifying
    @Transactional
    @Query(value = "UPDATE puntosAtencion SET tipo = :tipo, localizacion = :localizacion, oficina = :oficina WHERE id =:id", nativeQuery = true)
    void actualizarPuntoDeAtencion(@Param("id") int id,@Param("tipo") String tipo, @Param("localizacion") Direccion localizacion, @Param("oficina") Oficina oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntosAtencion WHERE id =:id", nativeQuery = true)
    void eliminarPuntoDeAtencion(@Param("id") ProductosPK id);}

