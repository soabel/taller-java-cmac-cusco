package com.cmaccusco.tallerjava.movimientos.data.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table()
public class Cuenta {
    @Id
    private String id;
    private String email;
    private String agencia;
    @Column(name = "nombre_persona")
    private String nombrePersona;
}
