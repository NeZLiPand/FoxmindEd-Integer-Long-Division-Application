package ua.com.foxminded.integerdivision.utility;

public abstract class IntegerCalculationUtilities {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int DECIMAL_BASE = 10;

    private IntegerCalculationUtilities() {
        throw new IllegalStateException("IntegerCalculationUtilities class");
    }

    public static int calculateAmountOfDigits(int number) {
        int countDigitsInNumber = NUM_ONE;
        while (number >= DECIMAL_BASE) {
            number /= DECIMAL_BASE;
            countDigitsInNumber++;
        }
        return countDigitsInNumber;
    }

    public static int[] arrayInitializationByDigitsOfNumber(int number) {
        int sizeArray = calculateAmountOfDigits(number);
        int[] arrayDigitsOfNumber = new int[sizeArray];
        for (int iteratorI = sizeArray; iteratorI > NUM_ZERO; iteratorI--) {
            arrayDigitsOfNumber[iteratorI - NUM_ONE] = number % DECIMAL_BASE;
            number /= DECIMAL_BASE;
        }
        return arrayDigitsOfNumber;
    }

    public static int digitFromNumber(int number,
                                      int indexFromRightToLeft) {
        int digitFromNumber = number;
        if (digitFromNumber >= DECIMAL_BASE) {
            if (indexFromRightToLeft > NUM_ONE) {
                digitFromNumber /= (int) Math.pow(DECIMAL_BASE, indexFromRightToLeft - NUM_ONE);
            }
            digitFromNumber %= DECIMAL_BASE;
        }
        return digitFromNumber;
    }
}
