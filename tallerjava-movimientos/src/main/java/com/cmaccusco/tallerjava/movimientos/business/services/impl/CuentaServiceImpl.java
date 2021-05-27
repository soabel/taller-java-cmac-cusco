package com.cmaccusco.tallerjava.movimientos.business.services.impl;

import com.cmaccusco.tallerjava.movimientos.business.services.CuentaService;
import com.cmaccusco.tallerjava.movimientos.data.entities.Cuenta;
import com.cmaccusco.tallerjava.movimientos.data.repositories.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    public List<Cuenta> findAll() {
        return this.cuentasRepository.findAll();
    }
}
