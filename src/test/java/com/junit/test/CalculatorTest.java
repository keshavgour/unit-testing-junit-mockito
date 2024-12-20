package com.junit.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @Test
    public void multiplyTest() {
        calculator = new Calculator();
        Assertions.assertEquals(15, calculator.multiply(3,5));

    }

    @Test
    public void divideTest() {
        calculator = new Calculator();
        Assertions.assertEquals(2, calculator.divide(10,5));
    }
}
