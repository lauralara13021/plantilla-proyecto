/*package uniandes.edu.co.proyecto.Repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query (value = "SELECT p FROM Persona p", nativeQuery = true)
    Collection<Persona> darPersona();
    
    @Query (value = "SELECT * FROM persona WHERE id = :id", nativeQuery = true)
    Persona darPersona(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO persona (id, numeroDocumento) VALUES(proyecto_sequence.nextval,:numeroDocumento)")
    void insertarPersona(@Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE persona SET numeroDocumento = :numeroDocumento WHERE id =:id", nativeQuery = true)
    void actualizarPersona(@Param("id")int id,@Param("numeroDocumento") String numeroDocumento);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM persona WHERE id =:id", nativeQuery = true)
    void eliminarPersona(@Param("id") int id);
  
}
*/