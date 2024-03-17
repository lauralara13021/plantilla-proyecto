package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.ProductosPK;


public interface PrestamoRepository extends JpaRepository<Prestamo,ProductosPK> {
    @Query(value = "SELECT p FROM Prestamo p")
    Collection<Prestamo> getPrestamo();

    @Query(value = "SELECT * FROM prestamos WHERE pk =:pk", nativeQuery = true )
    Prestamo getPrestamo(@Param("pk") ProductosPK pk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (pk, interes, cuotas, valorCuenta, monto, diaCorte) VALUES(bancandes_sequence.nextval, :interes, :cuotas, :valorCuenta, :monto, :diaCorte)", nativeQuery = true )
    void insertarPrestamo(@Param("interes") Double interes, @Param("cuotas") Integer cuotas, @Param("valorCuenta") String string, @Param("monto") Integer monto, @Param("diaCorte") String diaCorte);


    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET interes = :interes, cuotas = :cuotas, valorCuenta = :valorCuenta, monto = :monto, diaCorte = :diaCorte WHERE pk = :pk", nativeQuery = true)
    void actualizarPrestamo(@Param("pk") ProductosPK pk, @Param("interes") Double interes, @Param("cuotas") Integer cuotas, @Param("valorCuenta") String string, @Param("monto") Integer monto, @Param("diaCorte") String diaCorte);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE pk =:pk", nativeQuery = true)
    void eliminarPrestamo(@Param("pk") ProductosPK pk);
}
