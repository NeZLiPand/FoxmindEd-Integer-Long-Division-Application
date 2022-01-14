package ua.com.foxminded.integerdivision.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntegerCalculationUtilitiesTest {
    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsOneDigit() {
        assertEquals(1, IntegerCalculationUtilities.calculateAmountOfDigits(0));
    }

    @Test
    void testCalculateAmountOfDigits_shouldReturnTheSameAmountOfDigits_whenInputNumberContainsNineDigits() {
        assertEquals(9, IntegerCalculationUtilities.calculateAmountOfDigits(123_456_789));
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnDigitsArrayOfSameNumber_whenInputNumberContainsOne() {
        int[] arrayDigitsOfNumber = new int[] { 1 };
        assertEquals(arrayDigitsOfNumber[0], IntegerCalculationUtilities.arrayInitializationByDigitsOfNumber(1)[0]);
    }

    @Test
    void testArrayInitializationByDigitsOfNumber_shouldReturnArrayWithSameQuantityDigits_whenInputNumberContainsNineDigitNumber() {
        int[] arrayDigitsOfNumber = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertEquals(arrayDigitsOfNumber.length,
                    IntegerCalculationUtilities.arrayInitializationByDigitsOfNumber(123_456_789).length);
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineAndIndexContainOne() {
        assertEquals(9, IntegerCalculationUtilities.digitFromNumber(9, 1));
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutNinthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainNine() {
        assertEquals(1, IntegerCalculationUtilities.digitFromNumber(123_456_789, 9));
    }

    @Test
    void testdigitFromNumber_shouldReturnCutOutFifthDigitTheNumber_whenInputFirstNumberContainsNineDigitsAndIndexContainFive() {
        assertEquals(5, IntegerCalculationUtilities.digitFromNumber(123_456_789, 5));
    }
}
