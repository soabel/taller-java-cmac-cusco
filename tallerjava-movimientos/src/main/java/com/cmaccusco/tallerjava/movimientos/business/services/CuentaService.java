package com.cmaccusco.tallerjava.movimientos.business.services;

import com.cmaccusco.tallerjava.movimientos.data.entities.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta> findAll();
}
