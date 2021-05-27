package com.cmaccusco.tallerjava.movimientos.presentation.controllers;

import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovimientosController {

    private MovimientosService movimientosService;

    public MovimientosController(MovimientosService movimientosService){
        this.movimientosService= movimientosService;
    }

    @GetMapping
    public List<Movimiento> findAll() {
        return this.movimientosService.findAll();
    }

    @GetMapping("/{id}")
    public Movimiento findById(@PathVariable Integer id) {
        return this.movimientosService.findById(id);
    }

    @GetMapping("/por-agencia/{agencia}/{monto}/")
    public String findByAgencia(@PathVariable String agencia,
                                @PathVariable("monto") Double montoMovimiento,
                                @RequestParam("fecha") String fecha) {

        return "findByAgencia " + agencia.toString() + ", monto =" + montoMovimiento
                + ", fecha =" + fecha;
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
