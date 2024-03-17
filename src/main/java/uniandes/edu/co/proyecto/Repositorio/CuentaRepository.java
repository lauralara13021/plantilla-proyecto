package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.ProductosPK;


public interface CuentaRepository extends JpaRepository<Cuenta,ProductosPK> {
    @Query(value = "SELECT p FROM Cuenta p")
    Collection<Cuenta> getCuenta();

    @Query(value = "SELECT * FROM cuentas WHERE pk = :pk", nativeQuery = true )
    Cuenta getCuenta(@Param("pk") ProductosPK pk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (pk, cliente, estado, dinero) VALUES(bancandes_sequence.nextval,:estado, :tipo, :dinero)", nativeQuery = true )
    void insertarCuenta(@Param("estado") String estado,@Param("tipo") String tipo, @Param("dinero") Integer dinero);


    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET estado = :estado, tipo = :tipo,  dinero = :dinero WHERE pk =:pk", nativeQuery = true)
    void actualizarCuenta(@Param("pk") ProductosPK pk, @Param("estado") String estado, @Param("tipo") String tipo, @Param("dinero") Integer dinero);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE pk =:pk", nativeQuery = true)
    void eliminarCuenta(@Param("pk") ProductosPK pk);
  
}
