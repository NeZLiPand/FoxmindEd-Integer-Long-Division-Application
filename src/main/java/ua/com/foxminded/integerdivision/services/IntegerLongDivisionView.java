package ua.com.foxminded.integerdivision.services;

import ua.com.foxminded.integerdivision.libraries.Calculation;
import ua.com.foxminded.integerdivision.providers.IntegerLongDivisionProvider;

public class IntegerLongDivisionView {
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final char SYM_NEW_LINE = '\n';
    private static final char SYM_SUBTRACTION = '_';
    private static final char SYM_SPACE_DELIMITER = ' ';
    private static final char SYM_PILLAR = '|';
    private static final char SYM_FENCE = '-';

    public static String convertOnLongIntegerDivision(IntegerLongDivisionProvider integerLongDivision) {
        return convertIntegerDivisionOnLongIntegerDivision(integerLongDivision);
    }

    private static String convertIntegerDivisionOnLongIntegerDivision(IntegerLongDivisionProvider integerLongDivision) {
        StringBuilder sketchOfIntegerLongDivision = new StringBuilder("");
        int[] numeratorsOfDivisionColumns = integerLongDivision.getDivisionSteps().getNumeratorsOfDivisionColumns();
        int[] denomiratorsOfDivisionColumns = integerLongDivision.getDivisionSteps().getDenomiratorsOfDivisionColumns();
        int differenceInAmountDigitsNumeratorAndDenominator = Calculation
                .calculateAmountOfDigits(numeratorsOfDivisionColumns[NUM_ZERO])
                - Calculation.calculateAmountOfDigits(denomiratorsOfDivisionColumns[NUM_ZERO]);
        int differenceInAmountDigitsFirstNumeratorAndSecondNumerator = Calculation.calculateAmountOfDigits(
                numeratorsOfDivisionColumns[NUM_ZERO]) - differenceInAmountDigitsNumeratorAndDenominator;
        int amountSpaceDelimitersBeforePillar = Calculation.calculateAmountOfDigits(integerLongDivision.getDividend())
                - Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[NUM_ZERO]);
        addingFirstAndSecondLineOfLongDivision(sketchOfIntegerLongDivision, integerLongDivision,
                denomiratorsOfDivisionColumns, amountSpaceDelimitersBeforePillar,
                differenceInAmountDigitsNumeratorAndDenominator);
        addingThirdAndFourthLineOfLongDivision(sketchOfIntegerLongDivision, integerLongDivision,
                numeratorsOfDivisionColumns, denomiratorsOfDivisionColumns, amountSpaceDelimitersBeforePillar,
                differenceInAmountDigitsFirstNumeratorAndSecondNumerator);
        if (integerLongDivision.getDivisionSteps().getAmountMiniDivision() > NUM_ONE) {
            addingTailOfLongDivision(sketchOfIntegerLongDivision, integerLongDivision, numeratorsOfDivisionColumns,
                    denomiratorsOfDivisionColumns, differenceInAmountDigitsFirstNumeratorAndSecondNumerator);
        }
        return sketchOfIntegerLongDivision.toString();
    }

    private static void addingFirstAndSecondLineOfLongDivision(StringBuilder sketchOfIntegerLongDivision,
            IntegerLongDivisionProvider integerLongDivision, int[] denomiratorsOfDivisionColumns,
            int amountSpaceDelimitersBeforePillar, int differenceInAmountDigitsNumeratorAndDenominator) {
        sketchOfIntegerLongDivision.append(SYM_SUBTRACTION).append(integerLongDivision.getDividend()).append(SYM_PILLAR)
                .append(integerLongDivision.getDivider()).append(SYM_NEW_LINE).append(SYM_SPACE_DELIMITER);
        addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                differenceInAmountDigitsNumeratorAndDenominator);
        sketchOfIntegerLongDivision.append(denomiratorsOfDivisionColumns[NUM_ZERO]);
        addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                amountSpaceDelimitersBeforePillar);
        sketchOfIntegerLongDivision.append(SYM_PILLAR);
        if (integerLongDivision.getDivisionSteps().getAmountOfDivisionSteps() >= Calculation
                .calculateAmountOfDigits(integerLongDivision.getDivider())) {
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_FENCE,
                    integerLongDivision.getDivisionSteps().getAmountOfDivisionSteps());
        } else {
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_FENCE,
                    Calculation.calculateAmountOfDigits(integerLongDivision.getDivider()));
        }
        sketchOfIntegerLongDivision.append(SYM_NEW_LINE).append(SYM_SPACE_DELIMITER);
    }

    private static void addingThirdAndFourthLineOfLongDivision(StringBuilder sketchOfIntegerLongDivision,
            IntegerLongDivisionProvider integerLongDivision, int[] numeratorsOfDivisionColumns,
            int[] denomiratorsOfDivisionColumns, int amountSpaceDelimitersBeforePillar,
            int differenceInAmountDigitsFirstNumeratorAndSecondNumerator) {
        addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_FENCE,
                Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[NUM_ZERO]));
        addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                amountSpaceDelimitersBeforePillar);
        sketchOfIntegerLongDivision.append(SYM_PILLAR).append(integerLongDivision.getQuotient()).append(SYM_NEW_LINE);
        if (integerLongDivision.getDivisionSteps().getAmountMiniDivision() > NUM_ONE) {
            differenceInAmountDigitsFirstNumeratorAndSecondNumerator--;
        }
        addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                differenceInAmountDigitsFirstNumeratorAndSecondNumerator);
        if (integerLongDivision.getDivisionSteps().getAmountMiniDivision() > NUM_ONE) {
            if (numeratorsOfDivisionColumns[NUM_ZERO] - denomiratorsOfDivisionColumns[NUM_ZERO] == NUM_ZERO) {
                sketchOfIntegerLongDivision.append(SYM_SPACE_DELIMITER);
            }
            sketchOfIntegerLongDivision.append(SYM_SUBTRACTION).append(numeratorsOfDivisionColumns[NUM_ONE]);
        } else {
            sketchOfIntegerLongDivision.append(numeratorsOfDivisionColumns[NUM_ONE]);
        }
        if (integerLongDivision.getDivisionSteps().getAmountMiniDivision() > NUM_ONE) {
            sketchOfIntegerLongDivision.append(SYM_NEW_LINE);
        }
    }

    private static void addingTailOfLongDivision(StringBuilder sketchOfIntegerLongDivision,
            IntegerLongDivisionProvider integerLongDivision, int[] numeratorsOfDivisionColumns,
            int[] denomiratorsOfDivisionColumns, int differenceInAmountDigitsFirstNumeratorAndSecondNumerator) {
        int amountMiniDivisione = integerLongDivision.getDivisionSteps().getAmountMiniDivision();
        int amountSpaces = differenceInAmountDigitsFirstNumeratorAndSecondNumerator;
        if (NUM_ZERO == (numeratorsOfDivisionColumns[NUM_ZERO] - denomiratorsOfDivisionColumns[NUM_ZERO])) {
            amountSpaces = amountSpaces
                    + (Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[NUM_ZERO]) - NUM_ONE);
        }
        for (int iterator = NUM_ONE; iterator < amountMiniDivisione; iterator++) {
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                    amountSpaces + Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[iterator])
                            - Calculation.calculateAmountOfDigits(denomiratorsOfDivisionColumns[iterator]));
            sketchOfIntegerLongDivision.append(denomiratorsOfDivisionColumns[iterator]).append(SYM_NEW_LINE);
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER, amountSpaces);
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_FENCE,
                    Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[iterator]));
            sketchOfIntegerLongDivision.append(SYM_NEW_LINE);
            amountSpaces = amountSpaces + Calculation.calculateAmountOfDigits(numeratorsOfDivisionColumns[iterator])
                    - Calculation.calculateAmountOfDigits(
                            numeratorsOfDivisionColumns[iterator] - denomiratorsOfDivisionColumns[iterator]);
            if ((numeratorsOfDivisionColumns[iterator] == NUM_ZERO)
                    || (denomiratorsOfDivisionColumns[iterator] == NUM_ZERO)) {
                amountSpaces++;
            }
            addingMultipleCopiesOfSymbol(sketchOfIntegerLongDivision, SYM_SPACE_DELIMITER, amountSpaces - NUM_ONE);
            if (iterator != (amountMiniDivisione - NUM_ONE)) {
                sketchOfIntegerLongDivision.append(SYM_SUBTRACTION);
            } else {
                sketchOfIntegerLongDivision.append(SYM_SPACE_DELIMITER);
            }
            sketchOfIntegerLongDivision.append(numeratorsOfDivisionColumns[iterator + NUM_ONE]);
            if (iterator != (amountMiniDivisione - NUM_ONE)) {
                sketchOfIntegerLongDivision.append(SYM_NEW_LINE);
            }
        }
    }

    private static void addingMultipleCopiesOfSymbol(StringBuilder sketchOfIntegerLongDivision, char symbol,
            int quantity) {
        for (int iterator = NUM_ZERO; iterator < quantity; iterator++) {
            sketchOfIntegerLongDivision.append(symbol);
        }
    }
}
