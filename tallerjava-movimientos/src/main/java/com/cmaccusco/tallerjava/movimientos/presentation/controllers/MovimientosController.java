package com.cmaccusco.tallerjava.movimientos.presentation.controllers;

import com.cmaccusco.tallerjava.movimientos.business.dtos.MovimientoDto;
import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import com.cmaccusco.tallerjava.movimientos.presentation.controllers.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Movimiento> findByAgencia(@PathVariable String agencia) {
        return this.movimientosService.findByAgencia(agencia);
    }

    @GetMapping("/por-agencia-dto/{agencia}")
    public List<MovimientoDto> findByAgenciaDto(@PathVariable String agencia) {
        return this.movimientosService.findByAgenciaDto(agencia);
    }

    @GetMapping("/por-usuario/{usuario}")
    public List<Movimiento> findByUsuario(@PathVariable String usuario) {
        return this.movimientosService.findByUsuarioCreacion(usuario);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody Movimiento movimiento) {
        var result = this.movimientosService.save(movimiento);
        if(result==null){
            return ResponseEntity.badRequest().body(new BaseResponse("Cuenta bloqueada", null));
        }
      return ResponseEntity.ok(new BaseResponse("OK", result));
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
