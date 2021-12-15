package ua.com.foxminded.integerdivision.libraries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculationTest {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;
    private static final int NUM_FIVE = 5;
    private static final int NUM_SIX = 6;
    private static final int NUM_SEVEN = 7;
    private static final int NUM_EIGHT = 8;
    private static final int NUM_NINE = 9;
    private static final int NUM_ONE_TO_NINE = 123_456_789;

    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsOneDigit() {
        assertEquals(NUM_ONE, Calculation.calculateAmountOfDigits(NUM_ZERO));
    }

    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsNineDigits() {
        assertEquals(NUM_NINE, Calculation.calculateAmountOfDigits(NUM_ONE_TO_NINE));
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnDigitsArrayOfSameNumber_whenInputNumberContainsOne() {
        int[] arrayDigitsOfNumber = new int[] { NUM_ONE };
        assertEquals(arrayDigitsOfNumber[NUM_ZERO], Calculation.arrayInitializationByDigitsOfNumber(NUM_ONE)[NUM_ZERO]);
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnArrayWithSameQuantityDigits_whenInputNumberContainsNineDigitNumber() {
        int[] arrayDigitsOfNumber = new int[] { NUM_ONE, NUM_TWO, NUM_THREE, NUM_FOUR, NUM_FIVE, NUM_SIX, NUM_SEVEN,
                NUM_EIGHT, NUM_NINE };
        assertEquals(arrayDigitsOfNumber.length, Calculation.arrayInitializationByDigitsOfNumber(NUM_ONE_TO_NINE).length);
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineAndIndexContainOne() {
        assertEquals(NUM_NINE, Calculation.digitFromNumber(NUM_NINE, NUM_ONE));
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainNine() {
        assertEquals(NUM_ONE, Calculation.digitFromNumber(NUM_ONE_TO_NINE, NUM_NINE));
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutFifthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainFive() {
        assertEquals(NUM_FIVE, Calculation.digitFromNumber(NUM_ONE_TO_NINE, NUM_FIVE));
    }
}
