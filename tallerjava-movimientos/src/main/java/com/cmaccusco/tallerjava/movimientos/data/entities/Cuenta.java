package com.cmaccusco.tallerjava.movimientos.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
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
    private boolean bloqueado;
    private String dni;
    private Double saldo;

    @JsonIgnoreProperties(ignoreUnknown = true, value = {"cuenta"})
    @OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos;
}
