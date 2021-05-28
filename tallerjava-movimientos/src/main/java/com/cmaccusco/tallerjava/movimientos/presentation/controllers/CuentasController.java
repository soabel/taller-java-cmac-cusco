package com.cmaccusco.tallerjava.movimientos.presentation.controllers;

import com.cmaccusco.tallerjava.movimientos.business.services.CuentaService;
import com.cmaccusco.tallerjava.movimientos.core.mappers.MovimientoDtoMapper;
import com.cmaccusco.tallerjava.movimientos.data.entities.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cuentas")
public class CuentasController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> findAll(){
        return this.cuentaService.findAll();
    }

}
