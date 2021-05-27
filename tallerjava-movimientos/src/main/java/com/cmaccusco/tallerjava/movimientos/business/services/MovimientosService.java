package com.cmaccusco.tallerjava.movimientos.business.services;

import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;

import java.util.List;

public interface MovimientosService {
    List<Movimiento> findAll();
    Movimiento findById(Integer id);
    Movimiento save(Movimiento movimiento);
    Movimiento update(Movimiento movimiento);
    void delete(Integer id);
}
