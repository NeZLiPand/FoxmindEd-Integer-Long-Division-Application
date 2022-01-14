package ua.com.foxminded.integerdivision.provider;

import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionResult;
import ua.com.foxminded.integerdivision.genus.IntegerLongDivisionStep;
import ua.com.foxminded.integerdivision.utility.IntegerCalculationUtilities;

public class IntegerLongDivisionViewProviderImpl implements IntegerLongDivisionViewProvider {
    private static final char SYM_NEW_LINE = '\n';
    private static final char SYM_SUBTRACTION = '_';
    private static final char SYM_SPACE_DELIMITER = ' ';
    private static final char SYM_PILLAR = '|';
    private static final char SYM_FENCE = '-';

    @Override
    public String integerLongDivisionProvideView(IntegerLongDivisionResult integerLongDivisionResult) {
        return provideView(integerLongDivisionResult);
    }

    private String provideView(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder sketchOfIntegerLongDivision = new StringBuilder("");
        sketchOfIntegerLongDivision.append(addingFirstAndSecondLinesOfLongDivision(integerLongDivisionResult));
        sketchOfIntegerLongDivision.append(addingThirdLineOfLongDivision(integerLongDivisionResult));
        return sketchOfIntegerLongDivision.append(addingTailOfLongDivision(integerLongDivisionResult)).toString();
    }

    private String addingFirstAndSecondLinesOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder copySketchOfIntegerLongDivision = new StringBuilder("");
        int divided = integerLongDivisionResult.getIntegerDivisionResult().getDivided();
        int divisor = integerLongDivisionResult.getIntegerDivisionResult().getDivisor();
        List<IntegerLongDivisionStep> integerLongDivisionSteps = new ArrayList<>(
                    integerLongDivisionResult.getIntegerLongDivisionSteps());
        int amountOfDigitsInQuotient = IntegerCalculationUtilities.calculateAmountOfDigits(divided / divisor);
        int amountOfDigitsInDivisor = IntegerCalculationUtilities.calculateAmountOfDigits(divisor);
        int amountSpaceDelimitersBeforePillar = IntegerCalculationUtilities.calculateAmountOfDigits(divided)
            - IntegerCalculationUtilities
                        .calculateAmountOfDigits(integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns());
        copySketchOfIntegerLongDivision.append(SYM_SUBTRACTION).append(divided).append(SYM_PILLAR).append(divisor)
                    .append(SYM_NEW_LINE).append(SYM_SPACE_DELIMITER);
        addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                    (IntegerCalculationUtilities.calculateAmountOfDigits(
                                integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns())
                        - IntegerCalculationUtilities.calculateAmountOfDigits(
                                    integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns())));
        copySketchOfIntegerLongDivision.append(integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns());
        addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                    amountSpaceDelimitersBeforePillar);
        copySketchOfIntegerLongDivision.append(SYM_PILLAR);
        if (amountOfDigitsInQuotient >= amountOfDigitsInDivisor) {
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_FENCE, amountOfDigitsInQuotient);
        } else {
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_FENCE, amountOfDigitsInDivisor);
        }
        copySketchOfIntegerLongDivision.append(SYM_NEW_LINE).append(SYM_SPACE_DELIMITER);
        return copySketchOfIntegerLongDivision.toString();
    }

    private String addingThirdLineOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder copySketchOfIntegerLongDivision = new StringBuilder("");
        int divided = integerLongDivisionResult.getIntegerDivisionResult().getDivided();
        List<IntegerLongDivisionStep> integerLongDivisionSteps = new ArrayList<>(
                    integerLongDivisionResult.getIntegerLongDivisionSteps());
        int amountSpaceDelimitersBeforePillar = IntegerCalculationUtilities.calculateAmountOfDigits(divided)
            - IntegerCalculationUtilities
                        .calculateAmountOfDigits(integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns());
        addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_FENCE, IntegerCalculationUtilities
                    .calculateAmountOfDigits(integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns()));
        addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                    amountSpaceDelimitersBeforePillar);
        copySketchOfIntegerLongDivision.append(SYM_PILLAR)
                    .append(divided / integerLongDivisionResult.getIntegerDivisionResult().getDivisor())
                    .append(SYM_NEW_LINE);
        return copySketchOfIntegerLongDivision.toString();
    }

    private String addingTailOfLongDivision(IntegerLongDivisionResult integerLongDivisionResult) {
        StringBuilder copySketchOfIntegerLongDivision = new StringBuilder("");
        List<IntegerLongDivisionStep> integerLongDivisionSteps = new ArrayList<>(
                    integerLongDivisionResult.getIntegerLongDivisionSteps());
        int amountColumnsSubtraction = integerLongDivisionSteps.size();
        int amountSpacesBeforeValues = IntegerCalculationUtilities
                    .calculateAmountOfDigits(integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns())
            - IntegerCalculationUtilities
                        .calculateAmountOfDigits(integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns()
                            - integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns());
        if (amountColumnsSubtraction > 1) {
            if ((integerLongDivisionSteps.get(0).getNumeratorOfSubtractionColumns()
                - integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns()) == 0) {
                amountSpacesBeforeValues = amountSpacesBeforeValues
                    + IntegerCalculationUtilities.calculateAmountOfDigits(
                                integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns())
                    - 1;
            }
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                        amountSpacesBeforeValues);
            copySketchOfIntegerLongDivision.append(SYM_SUBTRACTION)
                        .append(integerLongDivisionSteps.get(1).getNumeratorOfSubtractionColumns())
                        .append(SYM_NEW_LINE);
        } else {
            if (integerLongDivisionResult.getIntegerDivisionResult().getRemainderOfTheDivision() == 0) {
                amountSpacesBeforeValues = amountSpacesBeforeValues + 1;
            }
            if (IntegerCalculationUtilities.calculateAmountOfDigits(
                        integerLongDivisionResult.getIntegerDivisionResult().getDivided()) > IntegerCalculationUtilities
                                    .calculateAmountOfDigits(
                                                integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns())) {
                amountSpacesBeforeValues = amountSpacesBeforeValues
                    + IntegerCalculationUtilities.calculateAmountOfDigits(
                                integerLongDivisionResult.getIntegerDivisionResult().getDivided())
                    - IntegerCalculationUtilities.calculateAmountOfDigits(
                                integerLongDivisionSteps.get(0).getDenominatorOfSubtractionColumns());
            }
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                        amountSpacesBeforeValues);
            copySketchOfIntegerLongDivision
                        .append(integerLongDivisionResult.getIntegerDivisionResult().getRemainderOfTheDivision());
        }
        for (int iterator = 1; iterator < amountColumnsSubtraction; iterator++) {
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                        amountSpacesBeforeValues + 1);
            copySketchOfIntegerLongDivision
                        .append(integerLongDivisionSteps.get(iterator).getDenominatorOfSubtractionColumns())
                        .append(SYM_NEW_LINE);
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                        amountSpacesBeforeValues + 1);
            addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_FENCE,
                        IntegerCalculationUtilities.calculateAmountOfDigits(
                                    integerLongDivisionSteps.get(iterator).getNumeratorOfSubtractionColumns()));
            amountSpacesBeforeValues = amountSpacesBeforeValues
                + IntegerCalculationUtilities.calculateAmountOfDigits(
                            integerLongDivisionSteps.get(iterator).getNumeratorOfSubtractionColumns())
                - IntegerCalculationUtilities.calculateAmountOfDigits(
                            integerLongDivisionSteps.get(iterator).getNumeratorOfSubtractionColumns()
                                - integerLongDivisionSteps.get(iterator).getDenominatorOfSubtractionColumns());
            copySketchOfIntegerLongDivision.append(SYM_NEW_LINE);
            if (iterator != (amountColumnsSubtraction - 1)) {
                if (integerLongDivisionSteps.get(iterator).getNumeratorOfSubtractionColumns() == 0) {
                    amountSpacesBeforeValues = amountSpacesBeforeValues
                        + IntegerCalculationUtilities.calculateAmountOfDigits(
                                    integerLongDivisionSteps.get(iterator).getNumeratorOfSubtractionColumns());
                }
                addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                            amountSpacesBeforeValues);
                copySketchOfIntegerLongDivision.append(SYM_SUBTRACTION)
                            .append(integerLongDivisionSteps.get(iterator + 1).getNumeratorOfSubtractionColumns());
            } else {
                addingMultipleCopiesOfSymbol(copySketchOfIntegerLongDivision, SYM_SPACE_DELIMITER,
                            amountSpacesBeforeValues);
                copySketchOfIntegerLongDivision.append(SYM_SPACE_DELIMITER)
                            .append(integerLongDivisionResult.getIntegerDivisionResult().getRemainderOfTheDivision());
            }
            if (iterator != (amountColumnsSubtraction - 1)) {
                copySketchOfIntegerLongDivision.append(SYM_NEW_LINE);
            }
        }
        return copySketchOfIntegerLongDivision.toString();
    }

    private void addingMultipleCopiesOfSymbol(StringBuilder sketchOfIntegerLongDivision,
                                              char symbol,
                                              int length) {
        for (int iterator = 0; iterator < length; iterator++) {
            sketchOfIntegerLongDivision.append(symbol);
        }
    }
}
