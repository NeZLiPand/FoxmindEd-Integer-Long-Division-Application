package ua.com.foxminded.integerdivision.provider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;

class IntegerLongDivisionMathProviderTest {
    IntegerLongDivisionMathProvider integerLongDivisionMathProvider = new IntegerLongDivisionMathProviderImpl();
    
    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputIntegersBigAndSmall() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(123, 99));
        DivisionSteps.add(new IntegerLongDivisionStep(244, 198));
        DivisionSteps.add(new IntegerLongDivisionStep(465, 396));
        DivisionSteps.add(new IntegerLongDivisionStep(696, 693));
        DivisionSteps.add(new IntegerLongDivisionStep(378, 297));
        DivisionSteps.add(new IntegerLongDivisionStep(819, 792));
        DivisionSteps.add(new IntegerLongDivisionStep(270, 198));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(123_456_789_0)
                                              .withDivisor(99)
                                              .withRemainder(72)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(123_456_789_0, 99));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedEqualsTheDivisorWithSmallNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(2, 2));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(2)
                                              .withDivisor(2)
                                              .withRemainder(0)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(2, 2));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedEqualsTheDivisorWithBigNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(123_456_789, 123_456_789));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(123_456_789)
                                              .withDivisor(123_456_789)
                                              .withRemainder(0)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(123_456_789, 123_456_789));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedLessTheDivisorWithSmallNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(2, 0));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(2)
                                              .withDivisor(3)
                                              .withRemainder(2)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(2, 3));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedLessTheDivisorWithBigNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(123456789, 0));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(123_456_789)
                                              .withDivisor(987_654_321)
                                              .withRemainder(123_456_789)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(123_456_789, 987_654_321));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedMoreTheDivisorWithSmallNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(4, 4));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(4)
                                              .withDivisor(2)
                                              .withRemainder(0)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(4, 2));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedMoreTheDivisorWithBigNumbers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(987_654_321, 987654312));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(987_654_321)
                                              .withDivisor(123_456_789)
                                              .withRemainder(9)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(987_654_321, 123_456_789));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputTheDividedEqualsZero() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(0)
                                              .withDivisor(2)
                                              .withRemainder(0)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(0, 2));
    }

    @Test
    void testIntegerLongDivisionProviderintegerDivision_shouldReturnIntegerLongDivision_whenInputSmallIntegers() {
        LinkedList<IntegerLongDivisionStep> DivisionSteps = new LinkedList<>();
        DivisionSteps.add(new IntegerLongDivisionStep(10, 10));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        DivisionSteps.add(new IntegerLongDivisionStep(0, 0));
        assertEquals(IntegerLongDivisionResult.builder()
                                              .withDivided(100_000_009)
                                              .withDivisor(10)
                                              .withRemainder(9)
                                              .withDivisionSteps(DivisionSteps)
                                              .build(),
                    integerLongDivisionMathProvider.provideMathIntegerLongDivision(100_000_009, 10));
    }
}
