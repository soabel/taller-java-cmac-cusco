package com.cmaccusco.tallerjava.movimientos.core.mappers;

import com.cmaccusco.tallerjava.movimientos.business.dtos.MovimientoDto;
import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoDtoMapper {
    @Mappings({
            @Mapping(source = "cuenta.id", target = "cuentaId"),
            @Mapping(source = "cuenta.nombrePersona", target = "nombrePersona")
    })
    MovimientoDto toMovimientoDto(Movimiento entity);
    List<MovimientoDto> toMovimientosDto(List<Movimiento> entities);
}
