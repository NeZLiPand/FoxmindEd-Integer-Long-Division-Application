package ua.com.foxminded.integerdivision.services;

import ua.com.foxminded.integerdivision.libraries.Calculation;
import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionProvider;
import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionStepsProvider;

public class IntegerLongDivisionMath {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TEN = 10;

    public static IntegerLongDivisionProvider provideMathDivision(int dividend, int divider) {
        return stepwiseDivision(dividend, divider);
    }

    private static IntegerLongDivisionProvider stepwiseDivision(int dividend, int divider) {
        int quotient = dividend / divider;
        int[] digitsValueQuotient = Calculation.arrayInitializationByDigitsOfNumber(quotient);
        IntegerLongDivisionProvider integerLongDivision = new IntegerLongDivisionProvider(dividend, divider, quotient,
                digitsValueQuotient);
        int amountOfDivisionSteps = Calculation.calculateAmountOfDigits(quotient);
        int numerator = dividend / (int) Math.pow(NUM_TEN, amountOfDivisionSteps - NUM_ONE);
        int AmountMiniDivision = returnAmountMiniDivision(digitsValueQuotient, numerator, dividend, divider,
                amountOfDivisionSteps);
        IntegerLongDivisionStepsProvider DivisionSteps = new IntegerLongDivisionStepsProvider(amountOfDivisionSteps,
                AmountMiniDivision);
        int[] numeratorsOfDivisionColumns = new int[AmountMiniDivision + NUM_ONE];
        int[] denomiratorsOfDivisionColumns = new int[AmountMiniDivision];
        int indexIterator = 1;
        numeratorsOfDivisionColumns[NUM_ZERO] = numerator;
        denomiratorsOfDivisionColumns[NUM_ZERO] = divider * digitsValueQuotient[NUM_ZERO];
        numerator = numerator - (divider * digitsValueQuotient[NUM_ZERO]);
        for (int iterator = NUM_ONE; iterator < amountOfDivisionSteps; iterator++) {
            if ((numerator != NUM_ZERO) && (numerator < divider)) {
                numerator = numerator * NUM_TEN
                        + Calculation.digitFromNumber(dividend, amountOfDivisionSteps - iterator);
            } else {
                numerator = Calculation.digitFromNumber(dividend, amountOfDivisionSteps - iterator);
            }
            if ((numerator == NUM_ZERO) || (numerator >= divider)) {
                numeratorsOfDivisionColumns[indexIterator] = numerator;
                denomiratorsOfDivisionColumns[indexIterator] = digitsValueQuotient[iterator] * divider;
                numerator = numerator - digitsValueQuotient[iterator] * divider;
                indexIterator++;
            }
        }
        numeratorsOfDivisionColumns[AmountMiniDivision] = numerator;
        DivisionSteps.setNumeratorsOfDivisionColumns(numeratorsOfDivisionColumns);
        DivisionSteps.setDenomiratorsOfDivisionColumns(denomiratorsOfDivisionColumns);
        integerLongDivision.setDivisionSteps(DivisionSteps);
        return integerLongDivision;

    }

    private static int returnAmountMiniDivision(int[] digitsValueQuotient, int numerator, int dividend, int divider,
            int amountOfDivisionSteps) {
        int AmountMiniDivision = 1;
        numerator = numerator - (divider * digitsValueQuotient[NUM_ZERO]);
        for (int iterator = NUM_ONE; iterator < amountOfDivisionSteps; iterator++) {
            if ((numerator != NUM_ZERO) && (numerator < divider)) {
                numerator = numerator * NUM_TEN
                        + Calculation.digitFromNumber(dividend, amountOfDivisionSteps - iterator);

            } else {
                numerator = Calculation.digitFromNumber(dividend, amountOfDivisionSteps - iterator);
            }
            if (numerator == NUM_ZERO || numerator >= divider) {
                numerator = numerator - digitsValueQuotient[iterator] * divider;
                AmountMiniDivision++;
            }
        }
        return AmountMiniDivision;
    }
}
