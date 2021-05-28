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
    private Double abono;
    private Double cargo;
    private String cuentaId;
    private String nombrePersona;
}
