package org.example;

import org.example.Junit.TemperatureConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.01);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.01);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.01);
    }

    @Test
    void testNegativeValues() {
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.01);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.01);
    }
}
