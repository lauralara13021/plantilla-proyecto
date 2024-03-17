/*package uniandes.edu.co.proyecto.Repositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionBancaria;

public interface OperacionBancariaRepository extends JpaRepository<OperacionBancaria, Integer> {
    @Query (value = "SELECT * FROM operacionesBancarias", nativeQuery = true)
    Collection<OperacionBancaria> darOperacionesBancarias();
    
    @Query (value = "SELECT * FROM operacionesBancarias WHERE id = :id", nativeQuery = true)
    OperacionBancaria darOperacionBancaria(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operacionesBancarias (id, hora, fecha, idOrigen, idDestino, puntoAtencion, valor, tipo) VALUES(proyecto_sequence.nextval, :hora, :fecha, :idOrigen, :idDestino, :puntoAtencion, :valor, :tipo)")
    void insertarOperacionBancaria(@Param("hora") LocalTime hora, @Param("fecha") LocalDate fecha, @Param("idOrigen") String idOrigen, @Param("idDestino") String idDestino, @Param("puntoAtencion") String puntoAtencion, @Param("valor") Integer valor);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE operacionesBancarias SET hora =:hora, fecha =:fecha, idOrigen =:idOrigen, idDestino =:idDestino, puntoAtencion =:puntoAtencion, valor=:valor, tipo=:tipo WHERE id =:id", nativeQuery = true)
    void actualizarOperacionBancaria(@Param("id") int id,@Param("hora") LocalTime hora, @Param("fecha") LocalDate fecha, @Param("idOrigen") String idOrigen, @Param("idDestino") String idDestino, @Param("puntoAtencion") String puntoAtencion, @Param("valor") Integer valor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM opcionesBancarias WHERE id =:id", nativeQuery = true)
    void eliminarOperacionBancaria(@Param("id") int id);
  



}
*/