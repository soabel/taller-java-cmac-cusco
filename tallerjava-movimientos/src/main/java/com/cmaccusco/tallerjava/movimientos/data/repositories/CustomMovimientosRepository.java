package com.cmaccusco.tallerjava.movimientos.data.repositories;

import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;

import java.util.List;

public interface CustomMovimientosRepository {
    List<Movimiento> findByAgencia(String agencia);
}
