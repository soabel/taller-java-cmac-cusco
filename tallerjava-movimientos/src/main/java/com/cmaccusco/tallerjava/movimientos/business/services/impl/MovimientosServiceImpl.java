package com.cmaccusco.tallerjava.movimientos.business.services.impl;

import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import com.cmaccusco.tallerjava.movimientos.data.repositories.MovimientosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    private MovimientosRepository movimientosRepository;

    public MovimientosServiceImpl(MovimientosRepository movimientosRepository){
        this.movimientosRepository=movimientosRepository;
    }

    @Override
    public List<Movimiento> findAll() {
        return this.movimientosRepository.findAll();
    }

    @Override
    public Movimiento findById(Integer id) {
        return this.movimientosRepository.findById(id).get();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return this.movimientosRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        this.movimientosRepository.deleteById(id);
    }
}
