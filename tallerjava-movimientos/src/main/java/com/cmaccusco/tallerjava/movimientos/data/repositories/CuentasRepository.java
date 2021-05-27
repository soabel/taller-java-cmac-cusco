package com.cmaccusco.tallerjava.movimientos.data.repositories;

import com.cmaccusco.tallerjava.movimientos.data.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasRepository extends JpaRepository<Cuenta, String> {
}
