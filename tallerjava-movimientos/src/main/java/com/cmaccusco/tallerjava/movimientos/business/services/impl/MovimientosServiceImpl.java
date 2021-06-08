package com.cmaccusco.tallerjava.movimientos.business.services.impl;

import com.cmaccusco.tallerjava.movimientos.business.dtos.MovimientoDto;
import com.cmaccusco.tallerjava.movimientos.business.services.MovimientosService;
import com.cmaccusco.tallerjava.movimientos.core.mappers.MovimientoDtoMapper;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import com.cmaccusco.tallerjava.movimientos.data.repositories.CuentasRepository;
import com.cmaccusco.tallerjava.movimientos.data.repositories.CustomMovimientosRepository;
import com.cmaccusco.tallerjava.movimientos.data.repositories.MovimientosRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimientosServiceImpl implements MovimientosService {

//    @Autowired
    private MovimientosRepository movimientosRepository;
//    @Autowired
    private MovimientoDtoMapper movimientoDtoMapper;
    private CuentasRepository cuentasRepository;

    public MovimientosServiceImpl(MovimientosRepository movimientosRepository,
                                  MovimientoDtoMapper movimientoDtoMapper,
                                  CuentasRepository cuentasRepository){
        this.movimientosRepository=movimientosRepository;
        this.movimientoDtoMapper=movimientoDtoMapper;
        this.cuentasRepository=cuentasRepository;
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

        var cuentaSaved = this.cuentasRepository.findById(movimiento.getCuenta().getId());

        if(!cuentaSaved.isPresent() ){
           return null;
        }

        if(cuentaSaved.get().isBloqueado()==true){
            return null;
        }

        if(movimiento.getCargo()>0){
            if(movimiento.getCargo() > cuentaSaved.get().getSaldo() ){
                return null;
            }
        }

        var result= this.movimientosRepository.save(movimiento);

        if(movimiento.getCargo()>0){
            cuentaSaved.get().setSaldo( cuentaSaved.get().getSaldo() - movimiento.getCargo());
        }
        if(movimiento.getAbono()>0){
            cuentaSaved.get().setSaldo( cuentaSaved.get().getSaldo() + movimiento.getAbono());
        }

        this.cuentasRepository.save(cuentaSaved.get());

        return result;

    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        this.movimientosRepository.deleteById(id);
    }

    @Override
    public List<MovimientoDto> findSimple() {

        return this.movimientoDtoMapper.toMovimientosDto( this.movimientosRepository.findAll());

//         return this.movimientosRepository
//                 .findAll().stream()
//                 .map(m-> {
//
//                     if(m.getCuenta() !=null){
//                         return new MovimientoDto(m.getFecha(), m.getAgencia(), m.getOperacion(),
//                                 m.getAbono(), m.getCargo(), m.getCuenta().getId(),
//                                 m.getCuenta().getNombrePersona() );
//                     }else{
//                         return new MovimientoDto(m.getFecha(), m.getAgencia(), m.getOperacion(),
//                                 m.getAbono(), m.getCargo(), null,
//                                 null);
//                     }
//
//                 })
//                 .collect(Collectors.toList());

    }

    @Override
    public List<Movimiento> findByAgencia(String agencia) {
//        return this.movimientosRepository.findByAgencia(agencia);
        return this.movimientosRepository.findByAgenciaV2(agencia);
    }

    @Override
    public List<MovimientoDto> findByAgenciaDto(String agencia) {
        return this.movimientosRepository.findByAgenciaV3(agencia);
    }

    @Override
    public List<Movimiento> findByUsuarioCreacion(String usuario) {
        return this.movimientosRepository.findByUsuarioCreacion(usuario);
    }

}
