package ua.com.foxminded.integerdivision.provider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import ua.com.foxminded.integerdivision.genus.IntegerDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;

class IntegerLongDivisionMathProviderTest {
    IntegerLongDivisionMathProvider integerLongDivisionMathProvider = new IntegerLongDivisionMathProviderImpl();

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputIntegersBigAndSmall() {
        LinkedList<IntegerLongDivisionStep> integerLongDivisionSteps = new LinkedList<>();
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(123, 99));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(244, 198));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(465, 396));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(696, 693));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(378, 297));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(819, 792));
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(270, 198));
        assertEquals(
                    new IntegerLongDivisionResult(new IntegerDivisionResult(1234567890, 99, 72),
                                integerLongDivisionSteps),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(123_456_789_0, 99));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputSmallIntegers() {
        LinkedList<IntegerLongDivisionStep> integerLongDivisionSteps = new LinkedList<>();
        integerLongDivisionSteps.add(new IntegerLongDivisionStep(3, 2));
        assertEquals(new IntegerLongDivisionResult(new IntegerDivisionResult(3, 2, 1), integerLongDivisionSteps),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(3, 2));
    }
}
