package com.cmaccusco.tallerjava.movimientos.presentation.controllers;

import com.cmaccusco.tallerjava.movimientos.business.dtos.MovimientoDto;
import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovimientosController {

//    @Autowired
    private MovimientosService movimientosService;

    public MovimientosController(MovimientosService movimientosService){
        this.movimientosService= movimientosService;
    }

    @GetMapping
    public List<Movimiento> findAll() {
        return this.movimientosService.findAll();
    }

    @GetMapping("/find-simple")
    public List<MovimientoDto> findSimple() {
        return this.movimientosService.findSimple();
    }

    @GetMapping("/{id}")
    public Movimiento findById(@PathVariable Integer id) {
        return this.movimientosService.findById(id);
    }

    @GetMapping("/por-agencia/{agencia}")
    public String findByAgencia(@PathVariable String agencia) {

        return "findByAgencia " + agencia.toString() + ", monto =";
    }

    @PostMapping
    public Movimiento save(@RequestBody Movimiento movimiento) {
      return this.movimientosService.save(movimiento);
    }

    @PutMapping
    public Movimiento updateAll(@RequestBody Movimiento movimiento) {
        System.out.println("updateAll = " + movimiento);
        return movimiento;
    }

    @PatchMapping
    public String updateState() {
        return "updateState ok";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.movimientosService.delete(id);
    }

}
