package com.cmaccusco.tallerjava.movimientos.business.dtos;

import lombok.*;

import javax.persistence.Column;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovimientoDto {
    private String fecha;
    private String agencia;
    private String operacion;
    private String abono;
    private String cargo;
    private String cuentaId;
    private String nombrePersona;
}
