package com.cmaccusco.tallerjava.movimientos.data.repositories;

import com.cmaccusco.tallerjava.movimientos.business.dtos.MovimientoDto;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimientosRepository extends JpaRepository<Movimiento, Integer>, CustomMovimientosRepository {

//    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
//    List<Movimiento> findByAbono(Double abono);

    @Query("SELECT m FROM Movimiento m WHERE m.agencia= :agencia")
    List<Movimiento> findByAgenciaV2(@Param("agencia") String agencia);

    @Query("SELECT m FROM Movimiento m WHERE m.agencia= :agencia")
    List<MovimientoDto> findByAgenciaV3(@Param("agencia") String agencia);

    @Query(value = "SELECT * FROM Movimiento WHERE Usuario_Creacion= :usuarioCreacion", nativeQuery = true)
    List<Movimiento> findByUsuarioCreacion(@Param("usuarioCreacion") String usuario);

//    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
//    User findUserByStatusAndNameNamedParams(
//            @Param("status") Integer status,
//            @Param("name") String name);


//    @Modifying
//    @Query("update User u set u.status = :status where u.name = :name")
//    int updateUserSetStatusForName(@Param("status") Integer status,
//                                   @Param("name") String name);
//

}
