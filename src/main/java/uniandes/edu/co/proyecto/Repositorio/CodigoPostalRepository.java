package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.CodigoPostal;



public interface CodigoPostalRepository extends JpaRepository<CodigoPostal,Integer> {
    @Query(value = "SELECT p FROM CodigoPostal p")
    Collection<CodigoPostal> getCodigoPostal();

    @Query(value = "SELECT * FROM codigoPostales WHERE id = :id", nativeQuery = true )
    CodigoPostal getCodigoPostal(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO codigoPostales (id, codigo, ciudad) VALUES(bancandes_sequence.nextval,:codigo, :ciudad)", nativeQuery = true )
    void insertarCodigoPostal(@Param("codigo") Integer codigo,@Param("ciudad") Ciudad ciudad);


    @Modifying
    @Transactional
    @Query(value = "UPDATE codigoPostales SET codigo = :codigo, ciudad = :ciudad WHERE id =:id", nativeQuery = true)
    void actualizarCodigoPostal(@Param("id") Integer id,@Param("codigo") Integer codigo,@Param("ciudad") Ciudad ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM codigoPostales WHERE id =:id", nativeQuery = true)
    void eliminarCodigoPostal(@Param("id") Integer id);
  
}
