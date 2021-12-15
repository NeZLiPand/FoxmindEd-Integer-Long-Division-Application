package ua.com.foxminded.integerdivision.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionProvider;
import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionStepsProvider;

class IntegerLongDivisionMathTest {
    
    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputBigIntegersDividendAndDivider() {
        int[] arrayDigitsOfNumber = new int[] { 1, 2, 4, 7, 0, 3, 8, 2 };
        int[] numeratorsOfDivisionColumns = new int[] { 123, 244, 465, 696, 378, 819, 270, 72 };
        int[] denomiratorsOfDivisionColumns = new int[] { 99, 198, 396, 693, 297, 792, 198 };
        IntegerLongDivisionStepsProvider DivisionSteps = new IntegerLongDivisionStepsProvider(
                numeratorsOfDivisionColumns, denomiratorsOfDivisionColumns, 8, 7);
        IntegerLongDivisionProvider integerLongDivision = new IntegerLongDivisionProvider(123_456_789_0, 99,
                123_456_789_0 / 99, arrayDigitsOfNumber, DivisionSteps);
        assertEquals(integerLongDivision.toString(), IntegerLongDivisionMath.provideMathDivision(123_456_789_0, 99).toString());
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputSmallIntegersDividendAndDivider() {
        int[] arrayDigitsOfNumber = new int[] { 1 };
        int[] numeratorsOfDivisionColumns = new int[] { 3, 1 };
        int[] denomiratorsOfDivisionColumns = new int[] { 2 };
        IntegerLongDivisionStepsProvider DivisionSteps = new IntegerLongDivisionStepsProvider(
                numeratorsOfDivisionColumns, denomiratorsOfDivisionColumns, 1, 1);
        IntegerLongDivisionProvider integerLongDivision = new IntegerLongDivisionProvider(3, 2, 3 / 2,
                arrayDigitsOfNumber, DivisionSteps);
        assertEquals(integerLongDivision.toString(), IntegerLongDivisionMath.provideMathDivision(3, 2).toString());
    }
}
