package ua.com.foxminded.integerdivision.utility;

public abstract class IntegerCalculationUtilities {
    private static final int DECIMAL_BASE = 10;

    private IntegerCalculationUtilities() {
        throw new IllegalStateException("IntegerCalculationUtilities class");
    }

    public static int calculateAmountOfDigits(int number) {
        int countDigitsInNumber = 1;
        while (number >= DECIMAL_BASE) {
            number /= DECIMAL_BASE;
            countDigitsInNumber++;
        }
        return countDigitsInNumber;
    }

    public static int[] arrayInitializationByDigitsOfNumber(int number) {
        int sizeArray = calculateAmountOfDigits(number);
        int[] arrayDigitsOfNumber = new int[sizeArray];
        for (int iteratorI = sizeArray; iteratorI > 0; iteratorI--) {
            arrayDigitsOfNumber[iteratorI - 1] = number % DECIMAL_BASE;
            number /= DECIMAL_BASE;
        }
        return arrayDigitsOfNumber;
    }

    public static int digitFromNumber(int number,
                                      int indexFromRightToLeft) {
        int digitFromNumber = number;
        if (digitFromNumber >= DECIMAL_BASE) {
            if (indexFromRightToLeft > 1) {
                digitFromNumber /= (int) Math.pow(DECIMAL_BASE, indexFromRightToLeft - 1);
            }
            digitFromNumber %= DECIMAL_BASE;
        }
        return digitFromNumber;
    }
}
