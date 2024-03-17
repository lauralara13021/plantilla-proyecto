package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;
import uniandes.edu.co.proyecto.modelo.Direccion;



public interface DireccionRepository extends JpaRepository<Direccion,Integer> {
    @Query(value = "SELECT p FROM Direccion p")
    Collection<Direccion> getDireccion();

    @Query(value = "SELECT * FROM direcciones WHERE id = :id", nativeQuery = true )
    Direccion getDireccion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO direcciones (id, direccion, codigoPostal) VALUES(bancandes_sequence.nextval,:direccion, :codigoPostal)", nativeQuery = true )
    void insertarDireccion(@Param("direccion") String direccion,@Param("codigoPostal") CodigoPostal codigoPostal);


    @Modifying
    @Transactional
    @Query(value = "UPDATE direcciones SET direccion = :direccion, codigoPostal = :codigoPostal,  dinero = :dinero WHERE id =:id", nativeQuery = true)
    void actualizarDireccion(@Param("id") Integer id, @Param("direccion") String direccion, @Param("codigoPostal") CodigoPostal codigoPostal);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM direcciones WHERE id =:id", nativeQuery = true)
    void eliminarDireccion(@Param("id") Integer id);
  
}
