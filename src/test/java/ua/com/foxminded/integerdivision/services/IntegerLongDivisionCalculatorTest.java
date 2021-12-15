package ua.com.foxminded.integerdivision.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntegerLongDivisionCalculatorTest {

    @Test
    void testlongIntegerDivisionCalculation_shouldCreateIntegerLongDivisionAndReturnSketchOfIntegerLongDivision_whenInputTwoIntegers() {
        assertEquals("_100|20\n" + " 100|--\n" + " ---|5\n" + "   0", IntegerLongDivisionCalculator.longIntegerDivisionCalculation(100, 20));
    }
}
