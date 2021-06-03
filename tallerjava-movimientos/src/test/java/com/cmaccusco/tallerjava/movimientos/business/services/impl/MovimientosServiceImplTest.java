package com.cmaccusco.tallerjava.movimientos.business.services.impl;

import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.core.mappers.MovimientoDtoMapper;
import com.cmaccusco.tallerjava.movimientos.data.entities.Cuenta;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import com.cmaccusco.tallerjava.movimientos.data.repositories.CuentasRepository;
import com.cmaccusco.tallerjava.movimientos.data.repositories.MovimientosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MovimientosServiceImplTest {


    @Autowired
    private MovimientosService movimientosService;
    @MockBean
    private CuentasRepository cuentasRepository;
    @MockBean
    private MovimientosRepository movimientosRepository;
    @Autowired
    private MovimientoDtoMapper mapper;

    @BeforeEach
    void setUp() {

//        this.movimientosService= new MovimientosServiceImpl(movimientosRepository, mapper, cuentasRepository );
    }

    @Test
    void save() {
        var cuentaRequest = new Cuenta();
        cuentaRequest.setId("12341");
        var movimientoRequest = new Movimiento();
        movimientoRequest.setCuenta(cuentaRequest);
        movimientoRequest.setId(123);
        movimientoRequest.setCargo(2000.0);

        var cuentaActual = new Cuenta();
        cuentaActual.setId("12341");
        cuentaActual.setBloqueado(false);
        cuentaActual.setSaldo(2500.0);

        when(this.cuentasRepository.findById(cuentaRequest.getId())).thenReturn(java.util.Optional.of(cuentaActual));
        when(this.movimientosRepository.save(movimientoRequest)).thenReturn(movimientoRequest);

        var actual = this.movimientosService.save(movimientoRequest);

        assertNotEquals(null, actual);
        assertNotEquals(0, actual.getId());

    }

    @Test
    void save_cuenta_no_existe() {
        var cuenta = new Cuenta();
        cuenta.setId("12341");
        var movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        var actual = this.movimientosService.save(movimiento);

        assertEquals(null, actual);
    }

    @Test
    void save_sin_saldo() {
        var cuentaRequest = new Cuenta();
        cuentaRequest.setId("12341");
        var movimientoRequest = new Movimiento();
        movimientoRequest.setCuenta(cuentaRequest);
        movimientoRequest.setId(123);
        movimientoRequest.setCargo(6000.0);

        var cuentaActual = new Cuenta();
        cuentaActual.setId("12341");
        cuentaActual.setBloqueado(false);
        cuentaActual.setSaldo(2500.0);

        when(this.cuentasRepository.findById(cuentaRequest.getId())).thenReturn(java.util.Optional.of(cuentaActual));
        when(this.movimientosRepository.save(movimientoRequest)).thenReturn(movimientoRequest);

        var actual = this.movimientosService.save(movimientoRequest);

        assertEquals(null, actual);

    }

    @Test
    void findSimple() {

        List<Movimiento> lista= new ArrayList<>();

        var cuentaRequest = new Cuenta();
        cuentaRequest.setId("12341");
        var movimientoRequest = new Movimiento();
        movimientoRequest.setCuenta(cuentaRequest);
        movimientoRequest.setId(123);
        movimientoRequest.setCargo(6000.0);


        lista.add(movimientoRequest);


        when(this.movimientosRepository.findAll()).thenReturn(lista);

        var actual = this.movimientosService.findSimple();

        assertNotEquals( null, actual);
        assertEquals(1, actual.size());

        System.out.println("actual = " + actual);

        assertEquals("S/ 6000.00", actual.get(0).getCargo());


    }
}