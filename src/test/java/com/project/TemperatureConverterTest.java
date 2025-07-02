package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {
    @Test
    public void fahrenheitToCelsiusTest(){
        assertEquals(0, TemperatureConverter.fahrenheitToCelsius(32));
        assertEquals(100, TemperatureConverter.fahrenheitToCelsius(212));
        assertEquals(-40, TemperatureConverter.fahrenheitToCelsius(-40));
        assertEquals(10, TemperatureConverter.fahrenheitToCelsius(50));
    }

    @Test
    public void celsiusToFahrenheitTest(){
        assertEquals(32, TemperatureConverter.celsiusToFahrenheit(0));
        assertEquals(212, TemperatureConverter.celsiusToFahrenheit(100));
        assertEquals(-40, TemperatureConverter.celsiusToFahrenheit(-40));
        assertEquals(50, TemperatureConverter.celsiusToFahrenheit(10));
    }
}
