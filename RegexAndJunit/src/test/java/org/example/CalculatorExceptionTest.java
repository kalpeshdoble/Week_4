package org.example.JunitQuestionsTest;

import org.example.JunitQuestions.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorExceptionTest {
    CalculatorException calculator = new CalculatorException();
    @Test
    void testDivideByNonZero() {
        assertEquals(5, calculator.divide(10, 2)); // 10 / 2 = 5
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
