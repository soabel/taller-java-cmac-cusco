package com.cmaccusco.tallerjava.movimientos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        this.calculadora= new Calculadora();
    }

    @Test
    void sumar() {
        System.out.println("sumar");
        var actual = this.calculadora.sumar(5,4);
        var expected = 9;

        assertNotEquals(0, actual);
        assertEquals(expected, actual);


    }

    @Test
    void sumar_2() {
        System.out.println("sumar");
        var actual = this.calculadora.sumar(5,4);
        var expected = 8;

        assertNotEquals(expected, actual);

    }

    @Test
    void restar() {
        System.out.println("restar");
        var actual = this.calculadora.restar(5,4);
        var expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void multiplicar(){
        Integer actual = this.calculadora.multiplicar(4,5);
        var expected= 20;
        assertEquals(expected,actual);
    }

}