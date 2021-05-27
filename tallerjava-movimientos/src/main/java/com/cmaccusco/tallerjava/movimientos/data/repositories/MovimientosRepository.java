package com.cmaccusco.tallerjava.movimientos.data.repositories;

import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimiento, Integer> {
}
