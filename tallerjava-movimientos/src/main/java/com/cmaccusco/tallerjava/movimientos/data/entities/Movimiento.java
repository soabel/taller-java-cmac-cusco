package com.cmaccusco.tallerjava.movimientos.data.entities;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity()
@Table(name = "Movimiento", schema = "dbo")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "cuentaId")
//    private String cuentaId;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "Hora")
    private String hora;
    @Column(name = "Agencia")
    private String agencia;
    @Column(name = "Operacion")
    private String operacion;
    @Column(name = "Abono")
    private Double abono;
    @Column(name = "Cargo")
    private Double cargo;
    @Column(name = "ITF")
    private Double itf;
    @Column(name = "SaldoContable")
    private Double saldoContable;
    @Column(name = "Usuario_Creacion")
    private String usuarioCreacion;

    @ManyToOne
    @JoinColumn(name = "cuentaId", nullable = true, updatable = false)
    private Cuenta cuenta;

}
