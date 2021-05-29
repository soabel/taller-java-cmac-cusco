package com.cmaccusco.tallerjava.movimientos.data.repositories.impl;

import com.cmaccusco.tallerjava.movimientos.data.entities.Movimiento;
import com.cmaccusco.tallerjava.movimientos.data.repositories.CustomMovimientosRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//@Repository
public class CustomMovimientosRepositoryImpl implements CustomMovimientosRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movimiento> findByAgencia(String agencia) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movimiento> query = cb.createQuery(Movimiento.class);
        Root<Movimiento> movimiento = query.from(Movimiento.class);

        query.select(movimiento)
                .where(cb.like(movimiento.get("agencia"), agencia + "%"));

        return entityManager.createQuery(query)
                .getResultList();

    }
}
