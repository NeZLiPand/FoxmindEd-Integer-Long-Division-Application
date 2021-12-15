package ua.com.foxminded.integerdivision.libraries;

public class Calculation {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TEN = 10;
    
    public static int calculateAmountOfDigits(int number) {
        int countDigitsInNumber = NUM_ONE;
        while (number >= NUM_TEN) {
            number /= NUM_TEN;
            countDigitsInNumber++;
        }
        return countDigitsInNumber;
    }

    public static int[] arrayInitializationByDigitsOfNumber(int number) {
        int sizeArray = calculateAmountOfDigits(number);
        int[] arrayDigitsOfNumber = new int[sizeArray];
        for (int iteratorI = sizeArray; iteratorI > NUM_ZERO; iteratorI--) {
            arrayDigitsOfNumber[iteratorI - NUM_ONE] = number % NUM_TEN;
            number /= NUM_TEN;
        }
        return arrayDigitsOfNumber;
    }

    public static int digitFromNumber(int number, int indexFromRightToLeft) {
        int digitFromNumber = number;
        if (digitFromNumber >= NUM_TEN) {
            if (indexFromRightToLeft > NUM_ONE) {
                digitFromNumber /= (int) Math.pow(NUM_TEN, indexFromRightToLeft - NUM_ONE);
            }
            digitFromNumber %= NUM_TEN;
        }
        return digitFromNumber;
    }
}
