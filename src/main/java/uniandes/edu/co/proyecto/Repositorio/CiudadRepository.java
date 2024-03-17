package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;




public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {
    @Query(value = "SELECT p FROM Ciudad p")
    Collection<Ciudad> getCiudad();

    @Query(value = "SELECT * FROM ciudades WHERE id = :id", nativeQuery = true )
    Ciudad getCiudad(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudades (id,ciudad,departamento) VALUES(bancandes_sequence.nextval,:ciudad, :departamento)", nativeQuery = true )
    void insertarCiudad(@Param("ciudad") String ciudad, @Param("departamento") String departamento);


    @Modifying
    @Transactional
    @Query(value = "UPDATE ciudades SET ciudad = :ciudad, departamento = :departamento WHERE id =:id", nativeQuery = true)
    void actualizarCiudad(@Param("id") Integer id,@Param("ciudad") String ciudad, @Param("departamento") String departamento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ciudades WHERE id =:id", nativeQuery = true)
    void eliminarCiudad(@Param("id") Integer id);
  
}