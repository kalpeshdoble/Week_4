package org.example;

import org.example.Junit.Calculator;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @org.junit.Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(2, -3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(5, calculator.subtract(2, -3));
        assertEquals(-2, calculator.subtract(0, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(2, -3));
        assertEquals(0, calculator.multiply(2, 0));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(6, -3));
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }
}
