package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Oficina;


public interface OficinaRepository extends JpaRepository<Oficina,Integer> {
    @Query(value = "SELECT p FROM Oficina p")
    Collection<Oficina> getOficina();

    @Query(value = "SELECT * FROM oficinas WHERE id = :id", nativeQuery = true )
    Oficina getOficina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO oficinas (id, nombre, direccion, puntosAtencion) VALUES(bancandes_sequence.nextval,:nombre, :direccion, :puntosAtencion)", nativeQuery = true )
    void insertarOficina(@Param("nombre") String nombre,@Param("direccion") Direccion direccion, @Param("puntosAtencion") Integer integer);


    @Modifying
    @Transactional
    @Query(value = "UPDATE oficinas SET nombre = :nombre, direccion = :direccion,  puntosAtencion= :puntosAtencion WHERE id =:id", nativeQuery = true)
    void actualizarOficina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("direccion") Direccion direccion,  @Param("puntosAtencion") Integer integer);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM oficinas WHERE id =:id", nativeQuery = true)
    void eliminarOficina(@Param("id") Integer id);
  
}