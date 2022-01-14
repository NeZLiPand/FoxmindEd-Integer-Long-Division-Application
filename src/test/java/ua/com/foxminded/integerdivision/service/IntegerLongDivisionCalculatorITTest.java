package ua.com.foxminded.integerdivision.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionMathProviderImpl;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProvider;
import ua.com.foxminded.integerdivision.provider.IntegerLongDivisionViewProviderImpl;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidator;
import ua.com.foxminded.integerdivision.validator.IntegerLongDivisionValidatorImpl;

class IntegerLongDivisionCalculatorITTest {
    IntegerLongDivisionValidator integerLongDivisionValidator = new IntegerLongDivisionValidatorImpl();
    IntegerLongDivisionMathProvider integerLongDivisionMathProvider = new IntegerLongDivisionMathProviderImpl();
    IntegerLongDivisionViewProvider integerLongDivisionViewProvider = new IntegerLongDivisionViewProviderImpl();
    IntegerLongDivisionCalculator integerLongDivisionCalculator = new IntegerLongDivisionCalculator(
                integerLongDivisionValidator, integerLongDivisionMathProvider, integerLongDivisionViewProvider);

    @Test
    void TestCalculateDivision_shouldReturnStringRepresentationOfIntegerLongDivision_whenInputDividedAndDivisor() {
        assertEquals("_987000321|2\n"
                     + " 8        |---------\n"
                     + " -        |493500160\n"
                     + "_18\n"
                     + " 18\n"
                     + " --\n"
                     + " _7\n"
                     + "  6\n"
                     + "  -\n"
                     + " _10\n"
                     + "  10\n"
                     + "  --\n"
                     + "  _0\n"
                     + "   0\n"
                     + "   -\n"
                     + "   _0\n"
                     + "    0\n"
                     + "    -\n"
                     + "    _3\n"
                     + "     2\n"
                     + "     -\n"
                     + "    _12\n"
                     + "     12\n"
                     + "     --\n"
                     + "      1",
                    integerLongDivisionCalculator.calculateDivision(987_000_321, 2));
    }
}
